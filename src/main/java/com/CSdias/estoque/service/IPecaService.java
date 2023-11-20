package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;

import com.CSdias.estoque.model.Kit;
import com.CSdias.estoque.model.Peca;

public interface IPecaService {
    
    public List<Peca> consultaPeca();

    public List<Peca> consultaPorNome(String nome);

    public Optional<Peca> consultaPorId(Long id);

    public Optional<Peca> cadastrarPeca(Peca peca);

    public Optional<Peca> atualizarPeca(Peca peca);

    public void excluirPeca(Long id);
}
