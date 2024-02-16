package br.com.academiaplaygym.academia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.academiaplaygym.academia.DTO.EnderecoRequestDTO;
import br.com.academiaplaygym.academia.model.Endereco;
import br.com.academiaplaygym.academia.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll() {
		return (List<Endereco>) enderecoRepository.findAll();
	}
	
	public Endereco save(Endereco endereco) {
		return (Endereco) enderecoRepository.save(endereco);
	
	}
	
	 public ResponseEntity update(EnderecoRequestDTO data) {
		 Optional<Endereco> optionalEnderecoModel = enderecoRepository.findById(data.id());
	     if (optionalEnderecoModel.isPresent()) {
	    	 Endereco enderecoModel = optionalEnderecoModel.get();
	    	 enderecoModel.setRua(data.rua());
	    	 enderecoModel.setNumero(data.numero());
	    	 enderecoModel.setBairro(data.bairro());
	    	 enderecoModel.setCep(data.cep());
	    	 enderecoModel.setCidade(data.cidade());
	    	 enderecoModel.setEstado(data.estado());
	    	 
	    	 enderecoRepository.save(enderecoModel);
	         
	         return ResponseEntity.ok(enderecoModel);
	         } else {
	            return ResponseEntity.notFound().build();
	         }
	 }
	 public ResponseEntity<String> deleteById(UUID id) {
		 enderecoRepository.deleteById(id);
		 return ResponseEntity.ok().build();
		}

}
