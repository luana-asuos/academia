package br.com.academiaplaygym.academia.DTO;

import java.util.UUID;

public record AlunoRequestDTO(
    UUID id,
    String nome,
    String dataNascimento,
    String telefone,
    String email,
    String rg,
    String cpf,
    String dataVencimento,
    EnderecoRequestDTO enderecoModel
) {
    
}
