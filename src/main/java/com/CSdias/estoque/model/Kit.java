package com.CSdias.estoque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // Impede erros no Json durante carregamentos lentos
@Entity

public class Kit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Peca peca;

    private String nome;

    private String descricao;

    private double valor;

    public Kit(Peca peca, String nome, String descricao, double valor) {
        this.peca = peca;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Kit() {
    }


    public Peca getPeca() {
        return this.peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
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
            throw new IllegalArgumentException("X - O nome não pode ficar em branco");
        } else {
            this.nome = nome;
        }
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("X - A descrição não pode ficar em branco");
        } else {
            this.descricao = descricao;
        }
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        try{
            if (valor <= 0) {
                throw new IllegalArgumentException("X - O valor deve ser maior que zero");
            } else {
                this.valor = valor;
            }
        } catch (Exception e) { 
            throw new IllegalArgumentException("X - O valor deve ser maior que zero");
        }
    }
}
