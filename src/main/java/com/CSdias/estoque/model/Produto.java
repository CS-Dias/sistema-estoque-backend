package com.CSdias.estoque.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Objects;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String descricao;

    private String modelo;

    private String cor;

    private double valorUnitario;

    @ManyToMany
    @JoinTable(
        name = "pecaProduto",
        joinColumns = @JoinColumn( name = "produto_id"),
        inverseJoinColumns = @JoinColumn( name = "peca_id")
    )
    Set<Peca> pecaProduto;

    @ManyToMany (mappedBy = "pedidoProduto")
    Set<Pedido> produtoPedido;

    public Produto() {
    }

    public Produto(String nome, String descricao, String modelo, String cor, double valorUnitario, Set<Peca> pecaProduto) {
        this.nome = nome;
        this.descricao = descricao;
        this.modelo = modelo;
        this.cor = cor;
        this.valorUnitario = valorUnitario;
        this.pecaProduto = pecaProduto;
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

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Set<Peca> getPecaProduto() {
        return this.pecaProduto;
    }

    public void setPecaProduto(Set<Peca> pecaProduto) {
        this.pecaProduto = pecaProduto;
    }

    public Set<Pedido> getProdutoPedido() {
        return this.produtoPedido;
    }

    public void setProdutoPedido(Set<Pedido> produtoPedido) {
        this.produtoPedido = produtoPedido;
    }
}