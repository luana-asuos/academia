package br.com.academiaplaygym.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academiaplaygym.academia.model.Endereco;

public interface EnderecoRepository<UUID> extends JpaRepository<Endereco, String>{

}
