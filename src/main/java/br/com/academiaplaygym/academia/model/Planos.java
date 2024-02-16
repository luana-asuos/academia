package br.com.academiaplaygym.academia.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Planos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)	@Column(nullable = false)
	private UUID id;
	
	@OneToMany
	private List<Aluno> listAlunoModel;
	
	@Column(nullable = false)
	private String tipoPlano;
	
	@Column(nullable = false)
	private double valor;

	public List<Aluno> getListAlunoModel() {
		return listAlunoModel;
	}

	public void setListAlunoModel(List<Aluno> listAlunoModel) {
		this.listAlunoModel = listAlunoModel;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
