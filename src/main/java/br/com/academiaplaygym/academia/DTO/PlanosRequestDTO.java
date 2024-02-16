package br.com.academiaplaygym.academia.DTO;

import java.util.UUID;

public record PlanosRequestDTO(
		
		UUID id,
		String tipoPlano,
		double valor
		
		) {

}
