package com.CSdias.estoque.service;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.CSdias.estoque.model.IKitRepository;
import com.CSdias.estoque.model.IPecaRepository;
import com.CSdias.estoque.model.Kit;
import com.CSdias.estoque.model.Peca;

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabase(IPecaRepository pecaRepository, IKitRepository kitRepository) {
        return args-> {
            Peca peca1 = new Peca("Rodinha basica", "estrutura", "preta", "Rodinha preta para cadeira basica", 4, 40);
            Peca peca2 = new Peca("Coluna basica", "estrutura", "preta", "Coluna para cadeira basica", 1, 10);
            Peca peca3 = new Peca("Estrela basica", "estrutura", "preta", "Estrela para cadeira basica", 1, 10);

            pecaRepository.saveAll(Arrays.asList(peca1, peca2, peca3));

            Kit kit = new Kit(1, "Kit basico", "Kit basico pra cadeira simples", 60.50);

            kitRepository.saveAll(Arrays.asList(kit));
            logger.info(">>> LoadDatabase -> Cadastro de 3 Kits realizado");
        };
    }
}
