package com.CSdias.estoque.service;

import com.CSdias.estoque.model.PecaProduto;
import com.CSdias.estoque.model.Produto;

import java.util.List;
import java.util.Optional;

public interface IPecaProdutoService {

   public List<PecaProduto> consultaPecaProduto();

   public Optional<PecaProduto> consultaPorId(Long id);

   public List<PecaProduto> consultaPorProduto(Produto produto);

   public Optional<PecaProduto> cadastrarPecaProduto(PecaProduto pecaProduto);

   public Optional<PecaProduto> atualizarPecaProduto(PecaProduto pecaProduto);

   public void deletarPecaProduto(Long id);
}
