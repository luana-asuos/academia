package br.com.academiaplaygym.academia.DTO;

import java.util.UUID;

public record TreinoRequestDTO(
		
		UUID id,
		String tipoTreino,
		String divisaoCorpo,
		int series,
		int repeticoes
	
		) {

}
