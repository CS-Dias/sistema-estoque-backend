package com.CSdias.estoque.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CSdias.estoque.model.Pedido;
import java.util.Set;


public interface IProdutoRepository extends JpaRepository<Produto, Long>{

    public Optional<Produto> findById(Long id);
    
    public List<Produto> findByNomeIgnoringCaseContaining(String nome);

    // public List<Produto> findByPedido(Set<Pedido> pedido);

    // public List<Produto> findByPeca(Set<Peca> peca);
}
