package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;

import com.CSdias.estoque.model.Kit;

public interface IKitService {

    public List<Kit> consultaEstoqueKit();
    public List<Kit> consultaPorNomeKit();

    public Optional<Kit> cadastrar(Kit kit);
    public Optional<Kit> consultarPorId(String id);
    public Optional<Kit> atualizar(Long id, Kit kit);
    public void excluir(Long id);
}
