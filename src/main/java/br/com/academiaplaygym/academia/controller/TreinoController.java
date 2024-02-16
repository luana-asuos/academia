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

import br.com.academiaplaygym.academia.DTO.TreinoRequestDTO;
import br.com.academiaplaygym.academia.model.Treino;
import br.com.academiaplaygym.academia.repository.TreinoRepository;
import br.com.academiaplaygym.academia.service.TreinoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/treino")
public class TreinoController {
	
	@Autowired
	private TreinoService treinoService;
	
	@GetMapping
	public List<Treino> findAll() {
		return treinoService.findAll();
	}
	
	@PostMapping
	public Treino save(@RequestBody @Valid Treino treino) {
		return treinoService.save(treino);
	}
	
	@PutMapping
	public ResponseEntity updateTreino(@RequestBody @Valid TreinoRequestDTO data) {
		return treinoService.update(data);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {
		
		return treinoService.deleteById(id);
	}

}
