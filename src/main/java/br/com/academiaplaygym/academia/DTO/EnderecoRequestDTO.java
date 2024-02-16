package br.com.academiaplaygym.academia.DTO;

import java.util.UUID;

public record EnderecoRequestDTO(
		
		UUID id,
		String rua,
		String numero,
		String bairro,
		String cep,
		String cidade,
		String estado
		
		) {

}
