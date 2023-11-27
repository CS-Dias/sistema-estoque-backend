package com.CSdias.estoque.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CSdias.estoque.model.IPedidoRepository;
import com.CSdias.estoque.model.Pedido;

@Service
public class PedidoService implements IPedidoService {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> consultaPedido() {
        logger.info(">>> Serviço consulta 'Pedido' iniciado");

        List<Pedido> pedido = pedidoRepository.findAll();

        return pedido;
    }

//    @Override
//    public List<Pedido> consultaPorData(Date data) {
//        logger.info(">>> Serviço 'Pedido' consultaPorData");
//
//        List<Pedido> pedido = pedidoRepository.findByDate(data);
//
//        return pedido;
//    }

    @Override
    public Optional<Pedido> consultaPorId(Long id) {
        logger.info(">>> Serviço 'Pedido' consultaPorId iniciado");

        Optional<Pedido> pedido = pedidoRepository.findById(id);

        return pedido;
    }

    @Override
    public Optional<Pedido> cadastrarPedido(Pedido pedido) {
        logger.info(">>> Serviço 'Pedido' cadastrarPedido iniciado");

        return Optional.ofNullable(pedidoRepository.save(pedido));
    }

    @Override
    public Optional<Pedido> atualizarPedido(Pedido newPedido) {
        logger.info(">>> Serviço 'Pedido' atualizarPedido' iniciado");

        return pedidoRepository.findById(newPedido.getId()).map(pedido -> {
            pedido.setCliente(newPedido.getCliente());
            pedido.setDescricao(newPedido.getDescricao());
            pedido.setDataPedido(newPedido.getDataPedido());

            return pedidoRepository.save(pedido);
        });
    }

    @Override
    public void excluirPedido(Long id) {
        logger.info(">>> Serviço 'Pedido' excluirProduto iniciado");

        pedidoRepository.deleteById(id);
    }

}
