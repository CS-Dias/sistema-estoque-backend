package com.CSdias.estoque.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CSdias.estoque.service.IProdutoPedidoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class APIProdutoPedidoController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IProdutoPedidoService produtoPedidoService;

    @CrossOrigin
    @GetMapping("produtopedido")
    @Transactional
    public ResponseEntity<Object> consultaProdutoPedido(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoPedidoService.consultaProdutoPedido());
    }
}
