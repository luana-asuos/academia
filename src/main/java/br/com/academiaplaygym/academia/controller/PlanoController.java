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

import br.com.academiaplaygym.academia.DTO.PlanosRequestDTO;
import br.com.academiaplaygym.academia.model.Planos;
import br.com.academiaplaygym.academia.service.PlanosService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/planos")
public class PlanoController {
	
	@Autowired
	private PlanosService planosService;
	
	@GetMapping
	public List<Planos> findAll() {
		return planosService.findAll();
	}
	
	@PostMapping
	public Planos save(@RequestBody @Valid Planos planos) {
		return planosService.save(planos);
	}
	
	@PutMapping
	public ResponseEntity<?> updatePlanos(@RequestBody @Valid PlanosRequestDTO data) {
	    return planosService.update(data);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {
		
		return planosService.deleteById(id);
	}

}
