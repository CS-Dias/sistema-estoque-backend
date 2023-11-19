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
    IKitRepository kitRepository;

    @Override
    public List<Kit> consultaKit() {
        logger.info(">>> Serviço consulta 'Kit' iniciado");

        List<Kit> kit = kitRepository.findAll();

        return kit;
    }

    @Override
    public List<Kit> consultaPorNome(String nome) {
        logger.info(">>> Serviço 'Kit' consultaPorNome iniciado");

        List<Kit> kit = kitRepository.findByNomeIgnoringCaseContaining(nome);

        return kit;
    }

    @Override
    public Optional<Kit> consultaPorId(Long id) {
        logger.info(">>> Serviço 'Professor' consultaPorId iniciado");

        Optional<Kit> kit = kitRepository.findById(id);

        return kit;
    }

    @Override
    public Optional<Kit> cadastrarKit(Kit kit) {
        logger.info(">>> Serviço 'Kit' cadastrarKit iniciado");

        return Optional.ofNullable(kitRepository.save(kit));
    }

    @Override
    public Optional<Kit> atualizarKit(Kit newKit) {
        logger.info(">>> Serviço 'Kit' atualizarKit iniciado");

        return kitRepository.findById(newKit.getId()).map(kit -> {
            kit.setNome(newKit.getNome());
            kit.setDescricao(newKit.getDescricao());
            kit.setValor(newKit.getValor());
            return kitRepository.save(kit);
        });
    }

    @Override
    public void excluirKit(Long id) {
        logger.info(">>> Serviço 'Kit' excluirKit iniciado");

        kitRepository.deleteById(id);
    }
}
