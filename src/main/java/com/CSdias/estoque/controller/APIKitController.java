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

import com.CSdias.estoque.model.Kit;
import com.CSdias.estoque.model.Resposta;
import com.CSdias.estoque.service.IKitService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")

public class APIKitController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IKitService kitService;

    @CrossOrigin // desabilita o cors do spring security
    @GetMapping("kit")
    @Transactional
    public ResponseEntity<Object> consultaKit(){
        logger.info(">>> ApiController consulta Kit");

        return ResponseEntity.status(HttpStatus.OK).body(kitService.consultaKit());
    }

    @CrossOrigin
    @GetMapping(value = "kit", params = "id")
    @Transactional
    public ResponseEntity<Object> consultaPorId(@RequestParam(value = "id") Long id){
        logger.info(">>> ApiController consulta Kit por ID");

        return ResponseEntity.status(HttpStatus.OK).body(kitService.consultaPorId(id));
    }

    @CrossOrigin
    @GetMapping(value = "kit", params = "nome")
    @Transactional
    public ResponseEntity<Object> consultaPorNome(@RequestParam(value = "nome") String nome){
        logger.info(">>> ApiController consulta Kit por ID");

        return ResponseEntity.status(HttpStatus.OK).body(kitService.consultaPorNome(nome));
    }

    @CrossOrigin
    @PostMapping("kit")
    @Transactional
    public ResponseEntity<Object> cadastrarKit(@RequestBody Kit kit){
        logger.info(">>> ApiController consulta Kit por ID");

        return ResponseEntity.status(HttpStatus.OK).body(kitService.cadastrarKit(kit));
    }

    @CrossOrigin
    @PatchMapping("kit")
    @Transactional
    public ResponseEntity<Object> atualizarKit(@RequestBody Kit kit){
        logger.info(">>> ApiController atualizar Kit");

        return ResponseEntity.status(HttpStatus.OK).body(kitService.atualizarKit(kit));
    }

    @CrossOrigin
    @DeleteMapping("kit/{id}")
    @Transactional
    public ResponseEntity<Object> excluirKit(@PathVariable Long id, HttpServletRequest req) {
        logger.info("apicontroller excluir professor");


        kitService.excluirKit(id);

        Resposta resposta = new Resposta();

        resposta.setMensagem(">>> Kit deletado com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }
}
