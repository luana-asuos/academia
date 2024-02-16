package br.com.academiaplaygym.academia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.academiaplaygym.academia.DTO.AlunoRequestDTO;
import br.com.academiaplaygym.academia.model.Aluno;
import br.com.academiaplaygym.academia.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> findAll() {
		return (List<Aluno>) alunoRepository.findAll();
	}
	
	public Aluno save(Aluno aluno) {
		return (Aluno) alunoRepository.save(aluno);
	
	}
	
	 public ResponseEntity update(AlunoRequestDTO data) {
		 Optional<Aluno> optionalAlunoModel = alunoRepository.findById(data.id());
	     if (optionalAlunoModel.isPresent()) {
	    	 Aluno alunoModel = optionalAlunoModel.get();
	    	 alunoModel.setNome(data.nome());
	         alunoModel.setEmail(data.email());
	         alunoModel.setTelefone(data.telefone());
	         alunoModel.setDataNascimento(data.dataNascimento());
	         alunoModel.setRg(data.rg());
	         alunoModel.setCpf(data.cpf());
	         alunoModel.setDataVencimento(data.dataVencimento());
	         
	         alunoRepository.save(alunoModel);
	         
	         return ResponseEntity.ok(alunoModel);
	         } else {
	            return ResponseEntity.notFound().build();
	         }
	 }
	 public ResponseEntity<String> deleteById(UUID id) {
		 alunoRepository.deleteById(id);
		 return ResponseEntity.ok().build();
		}
}
