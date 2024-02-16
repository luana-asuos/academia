package br.com.academiaplaygym.academia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.academiaplaygym.academia.DTO.PlanosRequestDTO;
import br.com.academiaplaygym.academia.model.Planos;
import br.com.academiaplaygym.academia.repository.PlanosRepository;

@Service
public class PlanosService {
	
	@Autowired
	private PlanosRepository planosRepository;
	
	public List<Planos> findAll() {
		return (List<Planos>) planosRepository.findAll();
	}
	
	public Planos save(Planos planos) {
		return (Planos) planosRepository.save(planos);
	
	}
	
	 public ResponseEntity update(PlanosRequestDTO data) {
		 Optional<Planos> optionalPlanosModel = planosRepository.findById(data.id());
	     if (optionalPlanosModel.isPresent()) {
	    	 Planos planosModel = optionalPlanosModel.get();
	    	 planosModel.setTipoPlano(data.tipoPlano());
	    	 planosModel.setValor(data.valor());
	    	 
	    	 planosRepository.save(planosModel);
	         
	         return ResponseEntity.ok(planosModel);
	         } else {
	            return ResponseEntity.notFound().build();
	         }
	 }
	 public ResponseEntity<String> deleteById(UUID id) {
		 planosRepository.deleteById(id);
		 return ResponseEntity.ok().build();
		}

}
