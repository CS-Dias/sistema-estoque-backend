package com.CSdias.estoque.controller;

import java.sql.Date;
import java.util.Optional;
import java.util.Set;

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
import com.CSdias.estoque.model.Pedido;
import com.CSdias.estoque.model.Produto;
import com.CSdias.estoque.model.Resposta;
import com.CSdias.estoque.service.IPedidoService;
import com.CSdias.estoque.service.IProdutoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class APIPedidoController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IProdutoService produtoService;

    @Autowired
    IPedidoService pedidoService;

    @CrossOrigin
    @GetMapping("pedido")
    @Transactional
    public ResponseEntity<Object> consultaPedido(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.consultaPedido());
    }

    @CrossOrigin
    @GetMapping(value = "pedido", params = "id")
    @Transactional
    public ResponseEntity<Object> consultaPorId(@RequestParam(value = "id") Long id){
        logger.info(">>> ApiController consulta Pedido por ID");

        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.consultaPorId(id));
    }

//    @CrossOrigin
//    @GetMapping(value = "pedido", params = "data")
//    @Transactional
//    public ResponseEntity<Object> consultaPorData(@RequestParam(value = "data") Date data){
//        logger.info(">>> ApiController consulta Pedido por Data");
//
//        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.consultaPorData(data));
//    }

    @CrossOrigin
    @PostMapping(value = "pedido")
    @Transactional
    public ResponseEntity<Object> cadastrarPedido(@RequestBody Pedido pedido){
        logger.info(">>> ApiController cadastrar Pedido");

        Optional<Pedido> newPedido = pedidoService.cadastrarPedido(pedido);

        return ResponseEntity.status(HttpStatus.OK).body(newPedido);
    }

    @CrossOrigin
    @PatchMapping("pedido")
    @Transactional
    public ResponseEntity<Object> atualizarPedido(@RequestBody Pedido pedido){
        logger.info(">>> ApiController atualizar Produto");

        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.atualizarPedido(pedido));
    }

    @CrossOrigin
    @DeleteMapping("pedido/{id}")
    @Transactional
    public ResponseEntity<Object> excluirPedido(@PathVariable Long id, HttpServletRequest req) {
        logger.info(">>> ApiController excluir pedido");


        pedidoService.excluirPedido(id);

        Resposta resposta = new Resposta();

        resposta.setMensagem(">>> Kit deletado com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }
}
