package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;

import com.CSdias.estoque.model.Produto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CSdias.estoque.model.IPecaProdutoRepository;
import com.CSdias.estoque.model.PecaProduto;

@Service
public class PecaProdutoService implements IPecaProdutoService {
   Logger logger = LogManager.getLogger(getClass());

   @Autowired
   IPecaProdutoRepository pecaProdutoRepository;

   public Logger getLogger() {
      return this.logger;
   }

   public void setLogger(Logger logger) {
      this.logger = logger;
   }

   @Override
   public List<PecaProduto> consultaPecaProduto() {
      logger.info("Servico PecaProduto - consulta dados iniciado");

      return pecaProdutoRepository.findAll();
   }

   @Override
   public Optional<PecaProduto> consultaPorId(Long id) {
      logger.info("Servico PecaProduto - consulta dados iniciado");

      return pecaProdutoRepository.findById(id);
   }

   @Override
   public List<PecaProduto> consultaPorProduto(Produto produto) {
      logger.info("Servico PecaProduto - consulta dados iniciado");
      return pecaProdutoRepository.findByProduto(produto);
   }

   @Override
   public Optional<PecaProduto> cadastrarPecaProduto(PecaProduto pecaProduto) {
      logger.info(">>> Serviço 'Kit' cadastrarKit iniciado");

      return Optional.ofNullable(pecaProdutoRepository.save(pecaProduto));
   }

   @Override
   public Optional<PecaProduto> atualizarPecaProduto(PecaProduto pecaProduto) {

      logger.info("Serviço PecaProduto - atualizar dados iniciado");

      return pecaProdutoRepository.findById(pecaProduto.getId()).map(item -> {
         item.setId(pecaProduto.getId());
         item.setPeca(pecaProduto.getPeca());
         item.setProduto(pecaProduto.getProduto());
         return pecaProdutoRepository.save(item);
      });

   }

   @Override
   public void deletarPecaProduto(Long id) {

      logger.info("Serviço PecaProduto - delete dados iniciado");

      pecaProdutoRepository.deleteById(id);

   }

}
