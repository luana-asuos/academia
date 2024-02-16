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

import br.com.academiaplaygym.academia.DTO.AlunoRequestDTO;
import br.com.academiaplaygym.academia.model.Aluno;
import br.com.academiaplaygym.academia.service.AlunoService;
import br.com.academiaplaygym.academia.util.CpfUtil;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public List<Aluno> findAll() {
		return alunoService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Aluno aluno) {
        String cpf = aluno.getCpf();
        // Verifica se o CPF está no formato correto e o formata se necessário
        cpf = CpfUtil.formatarCPF(cpf);
        if (!CpfUtil.isCPFValido(cpf)) {
            return ResponseEntity.badRequest().body("CPF inválido");
        }
        aluno.setCpf(cpf);
        Aluno savedAluno = alunoService.save(aluno);
        return ResponseEntity.ok(savedAluno);
	}
	
	@PutMapping
	public ResponseEntity<?> updateAluno(@RequestBody @Valid AlunoRequestDTO data) {
        String cpf = data.cpf();
        // Verifica se o CPF está no formato correto e o formata se necessário
        cpf = CpfUtil.formatarCPF(cpf);
        if (!CpfUtil.isCPFValido(cpf)) {
            return ResponseEntity.badRequest().body("CPF inválido");
        }
        data.cpf();
        return alunoService.update(data);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {
		
		return alunoService.deleteById(id);
	}

}
