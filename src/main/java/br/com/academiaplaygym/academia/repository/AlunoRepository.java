package br.com.academiaplaygym.academia.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academiaplaygym.academia.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, UUID>{

}
