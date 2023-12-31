package com.CSdias.estoque.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kit_id", referencedColumnName = "id")
    private Kit kit;

    private String nome;
    private String tipo;
    private String cor;
    private String descricao;
    private int quantidade;
    private int quantidadeMin;
    
    // @ManyToMany(mappedBy = "pecaProduto")
    // Set<Produto> produtoPeca;

    public Peca () {

    }


    public Peca(String nome, String tipo, String cor, String descricao, int quantidade, int quantidadeMin) {
        this.nome = nome;
        this.tipo = tipo;
        this.cor = cor;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.quantidadeMin = quantidadeMin;
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
        this.nome = nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeMin() {
        return this.quantidadeMin;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    // public Set<Produto> getProdutoPeca() {
    //     return this.produtoPeca;
    // }

    // public void setProdutoPeca(Set<Produto> produtoPeca) {
    //     this.produtoPeca = produtoPeca;
    // }
}

