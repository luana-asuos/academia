package br.com.academiaplaygym.academia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.academiaplaygym.academia.DTO.AlunoRequestDTO;
import br.com.academiaplaygym.academia.model.Aluno;
import br.com.academiaplaygym.academia.model.Endereco;
import br.com.academiaplaygym.academia.repository.AlunoRepository;
import br.com.academiaplaygym.academia.repository.EnderecoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Retornar todos os alunos
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    // Salvar um novo aluno
    public Aluno save(Aluno aluno) {
        Endereco endereco = aluno.getEnderecoModel();

        // Verifica se o endereço já existe no banco de dados
        if (endereco != null && endereco.getId() != null) {
            Optional<Endereco> enderecoExistente = enderecoRepository.findById(endereco.getId());
            if (enderecoExistente.isPresent()) {
                aluno.setEnderecoModel(enderecoExistente.get());
            } else {
                // Caso o endereço não exista, salva como novo
                enderecoRepository.save(endereco);
            }
        }

        // Salvar o aluno
        return alunoRepository.save(aluno);
    }

    // Atualizar um aluno existente
    public ResponseEntity<Aluno> update(AlunoRequestDTO data) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(data.id());

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();

            // Atualizar os dados do aluno
            aluno.setNome(data.nome());
            aluno.setEmail(data.email());
            aluno.setTelefone(data.telefone());
            aluno.setDataNascimento(data.dataNascimento());
            aluno.setRg(data.rg());
            aluno.setCpf(data.cpf());
            aluno.setDataVencimento(data.dataVencimento());

            // Salvar o aluno atualizado
            alunoRepository.save(aluno);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar um aluno pelo ID
    public ResponseEntity<String> deleteById(UUID id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return ResponseEntity.ok("Aluno deletado com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Aluno não encontrado.");
        }
    }
}
