package br.com.academiaplaygym.academia.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiaplaygym.academia.DTO.ProfessorRequestDTO;
import br.com.academiaplaygym.academia.model.Professor;
import br.com.academiaplaygym.academia.service.ProfessorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping
	public List<Professor> findAll() {
		return professorService.findAll();
	}
	
	@PostMapping
	public Professor save(@RequestBody @Valid Professor professor) {
		return professorService.save(professor);
	}
	
	@PutMapping
	public ResponseEntity<?> updateProfessor(@RequestBody @Valid ProfessorRequestDTO data) {
	    return professorService.update(data);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {
		
		return professorService.deleteById(id);
	}

}
