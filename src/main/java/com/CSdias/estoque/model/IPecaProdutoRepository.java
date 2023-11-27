package com.CSdias.estoque.model;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPecaProdutoRepository extends JpaRepository<PecaProduto, Long>{
   public List<PecaProduto> findByPeca(Optional <Peca> peca);
   public List<PecaProduto> findByProduto(Produto produto);
}
