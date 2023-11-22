package com.CSdias.estoque.model;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cliente;

    private String descricao;

    private String dataPedido;

    private double valor;

    @ManyToMany
    @JoinTable(
        name = "pedidoProduto",
        joinColumns = @JoinColumn( name = "pedido_id"),
        inverseJoinColumns = @JoinColumn( name = "produto_id")
    )
    Set<Produto> pedidoProduto;


    public Pedido() {
    }

    public Pedido(String cliente, String descricao, String dataPedido, double valor, Set<Produto> pedidoProduto) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.dataPedido = dataPedido;
        this.valor = valor;
        this.pedidoProduto = pedidoProduto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Set<Produto> getPedidoProduto() {
        return this.pedidoProduto;
    }

    public void setPedidoProduto(Set<Produto> pedidoProduto) {
        this.pedidoProduto = pedidoProduto;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

    
