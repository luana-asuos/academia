package br.com.academiaplaygym.academia.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Treino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)	@Column(nullable = false)
	private UUID id;
	
	@Column(nullable = false)
	private String tipoTreino;
	
	@Column(nullable = false)
	private String divisaoCorpo;
	
	@Column(nullable = false)
	private int series;
	
	@Column(nullable = false)
	private int repeticoes;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTipoTreino() {
		return tipoTreino;
	}

	public void setTipoTreino(String tipoTreino) {
		this.tipoTreino = tipoTreino;
	}

	public String getDivisaoCorpo() {
		return divisaoCorpo;
	}

	public void setDivisaoCorpo(String divisaoCorpo) {
		this.divisaoCorpo = divisaoCorpo;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}

}
