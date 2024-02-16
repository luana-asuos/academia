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

import br.com.academiaplaygym.academia.DTO.EnderecoRequestDTO;
import br.com.academiaplaygym.academia.model.Endereco;
import br.com.academiaplaygym.academia.service.EnderecoService;
import br.com.academiaplaygym.academia.util.CepUtil;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {


	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public List<Endereco> findAll() {
		return enderecoService.findAll();
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Endereco endereco) {
		String cep = endereco.getCep();
		// Verifica se o CEP está no formato correto e o formata se necessário
		cep = CepUtil.formatarCEP(cep);
		if (!CepUtil.isCEPValido(cep)) {
			return ResponseEntity.badRequest().body("CEP inválido");
		}
		endereco.setCep(cep);
		Endereco savedEndereco = enderecoService.save(endereco);
		return ResponseEntity.ok(savedEndereco);
	}

	@PutMapping
	public ResponseEntity<?> updateEndereco(@RequestBody @Valid EnderecoRequestDTO data) {
		String cep = data.cep();
		// Verifica se o CEP está no formato correto e o formata se necessário
		cep = CepUtil.formatarCEP(cep);
		if (!CepUtil.isCEPValido(cep)) {
			return ResponseEntity.badRequest().body("CEP inválido");
		}
		data.cep();
		return enderecoService.update(data);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {
		return enderecoService.deleteById(id);
	}
}
