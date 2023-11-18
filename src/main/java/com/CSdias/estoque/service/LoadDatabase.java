package com.CSdias.estoque.service;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.CSdias.estoque.model.IKitRepository;
import com.CSdias.estoque.model.Kit;

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabase(IKitRepository repository) {
        return args-> {
            Kit kit1 = new Kit("Conjunto Basico", "Conjunto cadeira simples", 15.50);
            Kit kit2 = new Kit("Conjunto Escritorio", "Conjunto cadeira Escritório", 49.99);
            Kit kit3 = new Kit("Conjunto CEO", "Conjunto cadeira CEO", 60.50);

            repository.saveAll(Arrays.asList(kit1, kit2, kit3));
            logger.info(">>> LoadDatabase -> Cadastro de 3 Kits realizado");
        };
    }
}
