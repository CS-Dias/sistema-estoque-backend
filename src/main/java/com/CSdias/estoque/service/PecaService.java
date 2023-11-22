package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CSdias.estoque.model.IKitRepository;
import com.CSdias.estoque.model.IPecaRepository;
import com.CSdias.estoque.model.Kit;
import com.CSdias.estoque.model.Peca;
import com.CSdias.estoque.model.Produto;

@Service
public class PecaService implements IPecaService {

    public Logger getLogger() {
        return this.logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public IPecaRepository getPecaRepository() {
        return this.pecaRepository;
    }

    public void setPecaRepository(IPecaRepository pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

    public IKitRepository getKitRepository() {
        return this.kitRepository;
    }

    public void setKitRepository(IKitRepository kitRepository) {
        this.kitRepository = kitRepository;
    }
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    IPecaRepository pecaRepository;

    @Autowired
    IKitRepository kitRepository;

    @Override
    public List<Peca> consultaPeca() {
        logger.info(">>> Serviço consulta 'Peca' iniciado");

        List<Peca> peca = pecaRepository.findAll();

        return peca;
    }

    @Override
    public List<Peca> consultaPorNome(String nome) {
        logger.info(">>> Serviço 'Peca' consultaPorNome");

        List<Peca> peca = pecaRepository.findByNomeIgnoringCaseContaining(nome);

        return peca;
    }

    @Override
    public Optional<Peca> consultaPorId(Long id) {
        logger.info(">>> Serviço 'Peca' consultaPorId iniciado");

        return pecaRepository.findById(id);
    }

    @Override
    public Optional<Peca> cadastrarPeca(Peca peca) {
       logger.info(">>> Serviço 'Peca' cadastrarPeca iniciado");

       return Optional.ofNullable(pecaRepository.save(peca));
    }

    @Override
    public Optional<Peca> atualizarPeca(Peca newPeca) {
        logger.info(">>> Serviço 'Peca' atualizarPeca iniciado");

        return pecaRepository.findById(newPeca.getId()).map(peca -> {
            peca.setNome(newPeca.getNome());
            peca.setCor(newPeca.getCor());
            peca.setDescricao(newPeca.getDescricao());
            peca.setQuantidade(newPeca.getQuantidade());
            peca.setQuantidadeMin(newPeca.getQuantidadeMin());
            peca.setTipo(newPeca.getTipo());

            return pecaRepository.save(peca);
        });
    }

    @Override
    public void excluirPeca(Long id) {
        logger.info("Serviço 'Peca' excluirPeca");

        pecaRepository.deleteById(id);
    }

    @Override
    public List<Peca> consultaByProduto(Set<Produto> produto) {
        logger.info(">>> Serviço 'Produto' consultaPorPedido inciado");

        List<Peca> peca = pecaRepository.findByProduto(produto);

        return peca;
    }

}
