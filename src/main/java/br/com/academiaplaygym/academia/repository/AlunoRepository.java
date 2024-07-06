package br.com.academiaplaygym.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academiaplaygym.academia.model.Aluno;

public interface AlunoRepository<UUID> extends JpaRepository<Aluno, String>{

}
