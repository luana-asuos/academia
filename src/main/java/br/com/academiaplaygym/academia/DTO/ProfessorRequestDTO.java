package br.com.academiaplaygym.academia.DTO;

import java.util.UUID;

public record ProfessorRequestDTO(
		
		UUID id,
		String nome,
		String email,
		String telefone,
		String cref
		
		) {

}
