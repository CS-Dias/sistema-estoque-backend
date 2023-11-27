package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.CSdias.estoque.model.Pedido;
import com.CSdias.estoque.model.Produto;

public interface IProdutoService {

    public List<Produto> consultaProduto();

    public List<Produto> consultaPorNome(String nome);

//    public List<Produto> consultaPorPedido(Set<Pedido> pedido);

    public Optional<Produto> consultarPorID(Long id);

    public Optional<Produto> cadastrarProduto(Produto produto);

    public Optional<Produto> atualizarProduto(Produto produto);

    public void excluirProduto(Long id);
}
