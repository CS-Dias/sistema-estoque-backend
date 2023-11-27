package com.CSdias.estoque.controller;

import java.util.Optional;
import java.util.Set;

import org.apache.catalina.connector.Response;
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

import com.CSdias.estoque.model.IPecaRepository;
import com.CSdias.estoque.model.Peca;
import com.CSdias.estoque.model.Pedido;
import com.CSdias.estoque.model.Produto;
import com.CSdias.estoque.model.Resposta;
import com.CSdias.estoque.service.IPecaService;
import com.CSdias.estoque.service.IPedidoService;
import com.CSdias.estoque.service.IProdutoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class APIProdutoController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IPecaService pecaService;

    @Autowired
    IPedidoService pedidoService;

    @Autowired
    IProdutoService produtoService;

    @CrossOrigin
    @GetMapping("produto")
    @Transactional
    public ResponseEntity<Object> consultaProduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.consultaProduto());
    }

    @CrossOrigin
    @GetMapping(value = "produto", params = "id")
    @Transactional
    public ResponseEntity<Object> consultaPorId(@RequestParam(value = "id") Long id){
        logger.info(">>> ApiController consulta Produto por ID");

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.consultarPorID(id));
    }

    @CrossOrigin
    @GetMapping(value = "produto", params = "nome")
    @Transactional
    public ResponseEntity<Object> consultaPorNome(@RequestParam(value = "nome") String nome){
        logger.info(">>> ApiConstroller consulta Produto por nome");

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.consultaPorNome(nome));
    }

    // @CrossOrigin
    // @GetMapping(value = "produto", params = "modelo")
    // @Transactional
    // public ResponseEntity<Object> consultaPorModelo(@RequestParam(value = "modelo") String modelo){
    //     logger.info(">>> ApiConstroller consulta produto por modelo");

    //     return ResponseEntity.status(HttpStatus.OK).body(produtoService.consultaPorModelo(modelo));
    // }

    @CrossOrigin
    @PostMapping(value = "produto")
    @Transactional
    public ResponseEntity<Object> cadastrarProduto(@RequestBody Produto produto){
        logger.info(">>> ApiController cadastrar Produto");

        Optional<Produto> newProduto = produtoService.cadastrarProduto(produto);

        return ResponseEntity.status(HttpStatus.OK).body(newProduto);
    }

    @CrossOrigin
    @PatchMapping("produto")
    @Transactional
    public ResponseEntity<Object> atualizarProduto(@RequestBody Produto produto){
        logger.info(">>> ApiController atualizar Produto");

        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizarProduto(produto));
    }

    @CrossOrigin
    @DeleteMapping("produto/{id}")
    @Transactional
    public ResponseEntity<Object> excluirProduto(@PathVariable Long id, HttpServletRequest req) {
        logger.info(">>> ApiController excluir produto");


        produtoService.excluirProduto(id);;

        Resposta resposta = new Resposta();

        resposta.setMensagem(">>> Kit deletado com sucesso");
        resposta.setStatus(HttpStatus.OK);
        resposta.setCaminho(req.getRequestURL().toString());
        resposta.setMetodo(req.getMethod());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }
}
