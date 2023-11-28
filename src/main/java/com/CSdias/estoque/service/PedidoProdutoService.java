package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.CSdias.estoque.model.IProdutoPedidoRepository;
import com.CSdias.estoque.model.Pedido;
import com.CSdias.estoque.model.ProdutoPedido;

public class PedidoProdutoService implements IProdutoPedidoService{
    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    IProdutoPedidoRepository produtoPedidoRepository;

    public Logger getLogger(){
        return this.logger;
    }

    public void setLogger(Logger logger){
        this.logger = logger;
    }

    @Override
    public List<ProdutoPedido> consultaProdutoPedido() {
       logger.info("Serviço ProdutoPedido consulta dados iniciado");

       return produtoPedidoRepository.findAll();
    }

    @Override
    public Optional<ProdutoPedido> consultaPorId(Long id) {
        logger.info("Serviço ProdutoPedido consulta dados iniciado");

       return produtoPedidoRepository.findById(id);
    }

    @Override
    public List<ProdutoPedido> consultaPorPedido(Pedido pedido) {
        logger.info("Serviço ProdutoPedido consulta dados iniciado");

       return produtoPedidoRepository.findByPedido(pedido);
    }
    
}
