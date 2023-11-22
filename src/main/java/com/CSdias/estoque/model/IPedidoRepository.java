package com.CSdias.estoque.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import com.CSdias.estoque.model.Produto;
import java.util.Set;



public interface IPedidoRepository extends JpaRepository <Pedido, Long>{

    public Optional<Pedido> findById(Long id);

    public List<Pedido> findByProduto(Set<Produto> produto);

    public List<Pedido> findByDate(Date data);
}
