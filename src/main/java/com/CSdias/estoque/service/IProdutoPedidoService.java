package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;

import com.CSdias.estoque.model.Pedido;
import com.CSdias.estoque.model.ProdutoPedido;

public interface IProdutoPedidoService {
    public List<ProdutoPedido> consultaProdutoPedido();

    public Optional<ProdutoPedido> consultaPorId(Long id);

    public List<ProdutoPedido> consultaPorPedido(Pedido pedido);
}
