package br.com.academiaplaygym.academia.model;

import java.util.UUID;

import br.com.academiaplaygym.academia.DTO.EnderecoRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;
    
    @Column(nullable = false)
    private String rua;
    
    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String bairro;
    
    @Column(nullable = false)
    private String cep;
    
    @Column(nullable = false)
    private String cidade;
    
    @Column(nullable = false)
    private String estado;

    public Endereco() {}

    public Endereco(EnderecoRequestDTO enderecoRequestDTO) {
        this.rua = enderecoRequestDTO.rua();
        this.numero = enderecoRequestDTO.numero();
        this.bairro = enderecoRequestDTO.bairro();
        this.cep = enderecoRequestDTO.cep();
        this.cidade = enderecoRequestDTO.cidade();
        this.estado = enderecoRequestDTO.estado();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
