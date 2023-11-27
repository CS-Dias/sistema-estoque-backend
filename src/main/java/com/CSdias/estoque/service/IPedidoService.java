package com.CSdias.estoque.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.CSdias.estoque.model.Pedido;

public interface IPedidoService {

    public List<Pedido> consultaPedido();

//    public List<Pedido> consultaPorData(Date data);

    public Optional<Pedido> consultaPorId(Long id);

    public Optional<Pedido> cadastrarPedido(Pedido pedido);

    public Optional<Pedido> atualizarPedido(Pedido pedido);

    public void excluirPedido(Long id);
}
