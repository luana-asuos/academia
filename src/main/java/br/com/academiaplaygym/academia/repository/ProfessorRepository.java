package br.com.academiaplaygym.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academiaplaygym.academia.model.Professor;

public interface ProfessorRepository<UUID> extends JpaRepository<Professor, String>{

}
