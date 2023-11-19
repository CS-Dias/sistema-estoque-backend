package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CSdias.estoque.model.IKitRepository;
import com.CSdias.estoque.model.IPecaRepository;
import com.CSdias.estoque.model.Kit;
import com.CSdias.estoque.model.Peca;

@Service
public class PecaService implements IPecaService {
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    IPecaRepository pecaRepository;

    @Autowired
    IKitRepository kitRepository;

    @Override
    public List<Peca> consultaPorKit(Optional<Kit> kit){
        logger.info(">>> Serviço 'Peca' consultaPorKit inciciado");

        List<Peca> peca = pecaRepository.findByKit(kit);

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
            peca.setKit(newPeca.getKit());
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
}
