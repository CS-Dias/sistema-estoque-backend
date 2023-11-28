package com.CSdias.estoque.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Long> {
    public List<PecaProduto> findByProduto(Optional<Produto> produto);

    public List<ProdutoPedido> findByPedido(Pedido pedido);
}
