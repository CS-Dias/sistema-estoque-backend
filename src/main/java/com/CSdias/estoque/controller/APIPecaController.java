package com.CSdias.estoque.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.RepaintManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CSdias.estoque.model.Kit;
import com.CSdias.estoque.model.Peca;
import com.CSdias.estoque.service.IKitService;
import com.CSdias.estoque.service.IPecaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class APIPecaController {
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    IPecaService pecaService;

    @Autowired
    IKitService kitService;

    @CrossOrigin
    @GetMapping(value = "pecas", params = "id")
    @Transactional
    public ResponseEntity<Object> consultaPeca(@RequestParam(value = "id") Long id) {
        logger.info("apicontroller consulta peca");

        Optional<Kit> kit = kitService.consultaPorId(id);

        List<Peca> peca = pecaService.consultaPorKit(kit);

        return ResponseEntity.status(HttpStatus.OK).body(peca);
    }

    
}
