package com.CSdias.estoque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) //Impede erros no Json durante carregamentos lentos
@Entity

public class Kit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nome;
    private String descricao;
    private double valor;

    public Kit(String nome, String descricao, double valor){
        setNome(nome);
        setDescricao(descricao);
        setValor(valor);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ficar em branco");
        } else {
             this.nome = nome;
        }
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("A descrição não pode ficar em branco");
        } else {
             this.descricao = descricao;
        }
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("A descrição não pode ficar em branco");
        } else {
             this.valor = valor;
        }
    }
}
