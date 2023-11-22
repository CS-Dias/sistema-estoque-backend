package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.CSdias.estoque.model.Kit;
import com.CSdias.estoque.model.Peca;
import com.CSdias.estoque.model.Pedido;
import com.CSdias.estoque.model.Produto;

public interface IPecaService {
    
    public List<Peca> consultaPeca();

    public List<Peca> consultaPorNome(String nome);

    public Optional<Peca> consultaPorId(Long id);

    public Optional<Peca> cadastrarPeca(Peca peca);

    public Optional<Peca> atualizarPeca(Peca peca);

    public List<Peca> consultaByProduto(Set<Produto> produto);

    public void excluirPeca(Long id);
}
