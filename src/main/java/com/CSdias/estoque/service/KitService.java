package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CSdias.estoque.model.IKitRepository;
import com.CSdias.estoque.model.Kit;

@Service
public class KitService implements IKitService {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    IKitRepository repository;

    @Override
    public List<Kit> consultaEstoqueKit() {
        return repository.findAll();
    }

    @Override
    public List<Kit> consultaPorNomeKit() {
        return null;
    }

    @Override
    public Optional<Kit> cadastrar(Kit kit) {
        return Optional.empty();
    }

    @Override
    public Optional<Kit> consultarPorId(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Kit> atualizar(Long id, Kit kit) {
        return Optional.empty();
    }

    @Override
    public void excluir(Long id) {
        
    }
}
