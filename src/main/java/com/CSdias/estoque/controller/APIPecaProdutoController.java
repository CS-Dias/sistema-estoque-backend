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
import com.CSdias.estoque.model.PecaProduto;
import com.CSdias.estoque.model.Resposta;
import com.CSdias.estoque.service.IPecaProdutoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
public class APIPecaProdutoController {
   Logger logger = LogManager.getLogger(this.getClass());

   @Autowired
   IPecaProdutoService pecaProdutoService;

   @CrossOrigin
   @GetMapping("pecaproduto")
   @Transactional
   public ResponseEntity<Object> consultaPecaProduto() {
      return ResponseEntity.status(HttpStatus.OK).body(pecaProdutoService.consultaPecaProduto());
   }

   @CrossOrigin
   @GetMapping(value = "pecaproduto", params = "id")
   @Transactional
   public ResponseEntity<Object> consultaPecaProdutoPorId(@RequestParam(value = "id") Long id) {

      logger.info(">>> ApiController consulta PecaProduto por ID");

      return ResponseEntity.status(HttpStatus.OK).body(pecaProdutoService.consultaPorId(id));

   }

   @CrossOrigin
   @PostMapping("pecaproduto")
   @Transactional
   public ResponseEntity<Object> cadastrarPecaProduto(@RequestBody PecaProduto pecaProduto) {
      logger.info(">>> ApiController cadastro PecaProduto");

      return ResponseEntity.status(HttpStatus.OK).body(pecaProdutoService.cadastrarPecaProduto(pecaProduto));
   }

   @CrossOrigin
   @PatchMapping("pecaproduto")
   @Transactional
   public ResponseEntity<Object> updatePecaProduto(@RequestBody PecaProduto pecaProduto) {

      logger.info(">>> ApiController update PecaProduto");

      return ResponseEntity.status(HttpStatus.OK).body(pecaProdutoService.atualizarPecaProduto(pecaProduto));
   }

   @CrossOrigin
   @DeleteMapping("pecaproduto/{id}")
   @Transactional
   public ResponseEntity<Object> deletePecaProduto(@PathVariable Long id, HttpServletRequest req) {
      logger.info(">>> ApiController delete PecaProduto");

      pecaProdutoService.deletarPecaProduto(id);

      Resposta resposta = new Resposta();

      resposta.setMensagem(">>> PecaProduto deletado com sucesso");
      resposta.setStatus(HttpStatus.OK);
      resposta.setCaminho(req.getRequestURL().toString());
      resposta.setMetodo(req.getMethod());

      return ResponseEntity.status(resposta.getStatus()).body(resposta);
   }
}
