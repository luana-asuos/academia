package br.com.academiaplaygym.academia.model;

import java.util.List;
import java.util.UUID;

import br.com.academiaplaygym.academia.DTO.AlunoRequestDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco enderecoModel;
	
	@OneToMany
	private List<Treino> treino;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String dataNascimento;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String rg;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String dataVencimento;
	
	public Aluno() {
		
	}

	public Aluno(AlunoRequestDTO alunoRequestDTO) {
		this.nome = alunoRequestDTO.nome();
		this.dataNascimento = alunoRequestDTO.dataNascimento();
		this.telefone = alunoRequestDTO.telefone();
		this.email = alunoRequestDTO.email();
		this.rg = alunoRequestDTO.rg();
		this.cpf = alunoRequestDTO.cpf();
		this.dataVencimento = alunoRequestDTO.dataVencimento();
	}
	

	public List<Treino> getTreino() {
		return treino;
	}

	public void setTreino(List<Treino> treino) {
		this.treino = treino;
	}

	public Endereco getEnderecoModel() {
		return enderecoModel;
	}

	public void setEnderecoModel(Endereco enderecoModel) {
		this.enderecoModel = enderecoModel;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	
	
	
}
