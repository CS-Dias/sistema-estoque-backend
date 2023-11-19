package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;

import com.CSdias.estoque.model.Kit;

public interface IKitService {

    public List<Kit> consultaKit();

    public List<Kit> consultaPorNome(String nome);

    public Optional<Kit> consultaPorId(Long id);

    public Optional<Kit> cadastrarKit(Kit kit);

    public Optional<Kit> atualizarKit(Kit kit);

    public void excluirKit(Long id);
}
