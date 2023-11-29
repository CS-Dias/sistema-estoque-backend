package com.CSdias.estoque.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CSdias.estoque.model.Peca;
import com.CSdias.estoque.model.Resposta;
import com.CSdias.estoque.service.IKitService;
import com.CSdias.estoque.service.IPecaService;

import jakarta.servlet.http.HttpServletRequest;
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
    @GetMapping("peca")
    @Transactional
    public ResponseEntity<Object> consultaPeca() {
        logger.info(">>> ApiController consulta Peca");

        return ResponseEntity.status(HttpStatus.OK).body(pecaService.consultaPeca());
    }

    // public ResponseEntity<Object> consultaPecaPorKit(@RequestParam(value =
    // "id_kit") Long id_kit) {
    // logger.info("apicontroller consulta peca por Kit");

    // Optional<Kit> kit = kitService.consultaPorId(id_kit);

    // return
    // ResponseEntity.status(HttpStatus.OK).body(pecaService.consultaPorKit(kit));
    // }

    @CrossOrigin
    @GetMapping(value = "peca", params = "id")
    @Transactional
    public ResponseEntity<Object> consultaPorId(@RequestParam(value = "id") Long id) {
        logger.info(">>> ApiController consulta Peca por ID");

        return ResponseEntity.status(HttpStatus.OK).body(pecaService.consultaPorId(id));
    }

    @CrossOrigin
    @GetMapping(value = "peca", params = "nome")
    @Transactional
    public ResponseEntity<Object> consultaPorNome(@RequestParam(value = "nome") String nome) {
        logger.info(">>> ApiController consulta peca por ID");

        return ResponseEntity.status(HttpStatus.OK).body(pecaService.consultaPorNome(nome));
    }

    @CrossOrigin
    @GetMapping(value = "peca", params = "tipo")
    @Transactional
    public ResponseEntity<Object> consultaPorTipo(@RequestParam(value = "tipo") String tipo) {
        logger.info(">>> ApiController consulta peca por Tipo");

        return ResponseEntity.status(HttpStatus.OK).body(pecaService.consultaPorTipo(tipo));
    }

    @CrossOrigin
    @PostMapping("peca")
    @Transactional
    public ResponseEntity<Object> cadastrarPeca(@RequestBody Peca peca) {
        logger.info(">>> ApiController CadastraPeca");

        return ResponseEntity.status(HttpStatus.OK).body(pecaService.cadastrarPeca(peca));
    }

    // @CrossOrigin
    // @PostMapping(value = "peca")
    // @Transactional
    // public ResponseEntity<Object> cadastrarPeca(@RequestParam(value = "kit_id")
    // Long kit_id,
    // @RequestBody Peca peca) {
    // logger.info("apicontroller cadastrar peca");

    // Optional<Kit> kit = kitService.consultaPorId(kit_id);

    // peca.setKit(kit.get());

    // Optional<Peca> newPeca = pecaService.cadastrarPeca(peca);

    // return ResponseEntity.status(HttpStatus.OK).body(newPeca);
    // }

    @CrossOrigin
    @PatchMapping("peca")
    @Transactional
    public ResponseEntity<Object> atualizarPeca(@RequestBody Peca peca) {
        logger.info("apicontroller editar peca");

        return ResponseEntity.status(HttpStatus.OK).body(pecaService.atualizarPeca(peca));
    }

    @CrossOrigin
    @DeleteMapping("peca/{id}")
    @Transactional
    public ResponseEntity<Object> excluirPeca(@PathVariable Long id, HttpServletRequest req) {
        logger.info("apicontroller excluir peca");

        pecaService.excluirPeca(id);

        Resposta resposta = new Resposta();

        resposta.setMensagem("Peca deletada com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }
}