package br.com.academiaplaygym.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academiaplaygym.academia.model.Planos;

public interface PlanosRepository<UUID> extends JpaRepository<Planos, String>{

}
