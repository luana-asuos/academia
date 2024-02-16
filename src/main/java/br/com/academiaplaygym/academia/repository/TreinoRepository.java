package br.com.academiaplaygym.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academiaplaygym.academia.model.Treino;

public interface TreinoRepository<UUID> extends JpaRepository<Treino, String>{

}
