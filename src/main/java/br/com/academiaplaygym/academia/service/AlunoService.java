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

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno save(Aluno aluno) {
        Endereco endereco = aluno.getEnderecoModel();

        if (endereco != null && endereco.getId() != null) {
            Optional<Endereco> enderecoExistente = enderecoRepository.findById(endereco.getId());
            if (enderecoExistente.isPresent()) {
                aluno.setEnderecoModel(enderecoExistente.get());
            } else {
                enderecoRepository.save(endereco);
            }
        }

        return alunoRepository.save(aluno);
    }

    public ResponseEntity<?> update(UUID id, AlunoRequestDTO data) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);
        if (aluno == null) {
            return ResponseEntity.status(404).body("Aluno não encontrado");
        }

        aluno.setNome(data.nome());
        aluno.setCpf(data.cpf());
        aluno.setEmail(data.email());
        aluno.setTelefone(data.telefone());
        aluno.setDataNascimento(data.dataNascimento());
        aluno.setRg(data.rg());
        aluno.setDataVencimento(data.dataVencimento());

        if (data.enderecoModel() != null) {
            Endereco endereco = new Endereco(data.enderecoModel());
            aluno.setEnderecoModel(endereco);
        }

        alunoRepository.save(aluno);

        return ResponseEntity.ok(aluno);
    }

    public ResponseEntity<String> deleteById(UUID id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return ResponseEntity.ok("Aluno deletado com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Aluno não encontrado.");
        }
    }

    public Aluno findById(UUID id) {
        return alunoRepository.findById(id).orElse(null);
    }
}
