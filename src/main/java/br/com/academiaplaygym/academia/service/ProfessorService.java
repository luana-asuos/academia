package br.com.academiaplaygym.academia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.academiaplaygym.academia.DTO.ProfessorRequestDTO;
import br.com.academiaplaygym.academia.model.Aluno;
import br.com.academiaplaygym.academia.model.Professor;
import br.com.academiaplaygym.academia.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> findAll() {
		return (List<Professor>) professorRepository.findAll();
	}
	
	public Professor save(Professor professor) {
		return (Professor) professorRepository.save(professor);
	
	}
	
	 public ResponseEntity update(ProfessorRequestDTO data) {
		 Optional<Professor> optionalProfessorModel = professorRepository.findById(data.id());
	     if (optionalProfessorModel.isPresent()) {
	    	 Professor professorModel = optionalProfessorModel.get();
	    	 professorModel.setNome(data.nome());
	    	 professorModel.setEmail(data.email());
	    	 professorModel.setTelefone(data.telefone());
	    	 professorModel.setCref(data.cref());
	    	 
	    	 professorRepository.save(professorModel);
	         
	         return ResponseEntity.ok(professorModel);
	         } else {
	            return ResponseEntity.notFound().build();
	         }
	 }
	 public ResponseEntity<String> deleteById(UUID id) {
		 professorRepository.deleteById(id);
		 return ResponseEntity.ok().build();
		}
	
}
