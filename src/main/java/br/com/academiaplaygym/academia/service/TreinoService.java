package br.com.academiaplaygym.academia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.academiaplaygym.academia.DTO.TreinoRequestDTO;
import br.com.academiaplaygym.academia.model.Treino;
import br.com.academiaplaygym.academia.repository.TreinoRepository;

@Service
public class TreinoService {
	
	@Autowired
	private TreinoRepository treinoRepository;
	
	public List<Treino> findAll() {
		return (List<Treino>) treinoRepository.findAll();
	}
	
	public Treino save(Treino treino) {
		return (Treino) treinoRepository.save(treino);
	
	}
	
	 public ResponseEntity update(TreinoRequestDTO data) {
		 Optional<Treino> optionalTreinoModel = treinoRepository.findById(data.id());
	     if (optionalTreinoModel.isPresent()) {
	    	 Treino treinoModel = optionalTreinoModel.get();
	    	 treinoModel.setTipoTreino(data.tipoTreino());
	    	 treinoModel.setDivisaoCorpo(data.divisaoCorpo());
	    	 treinoModel.setSeries(data.series());
	    	 treinoModel.setRepeticoes(data.repeticoes());
	    	 
	    	 treinoRepository.save(treinoModel);
	         
	         return ResponseEntity.ok(treinoModel);
	         } else {
	            return ResponseEntity.notFound().build();
	         }
	 }
	 public ResponseEntity<String> deleteById(UUID id) {
		 treinoRepository.deleteById(id);
		 return ResponseEntity.ok().build();
		}

}
