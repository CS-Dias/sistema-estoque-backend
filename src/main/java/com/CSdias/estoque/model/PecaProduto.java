package com.CSdias.estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PecaProduto {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long Id;

   @ManyToOne
   @JoinColumn (name = "peca_id", referencedColumnName = "id")
   private Peca peca;

   @ManyToOne
   @JoinColumn(name = "produto_id", referencedColumnName = "id")
   private Produto produto;

   public PecaProduto(){}

   public PecaProduto(Peca peca, Produto produto) {
      this.peca = peca;
      this.produto = produto;
   }

   public Long getId() {
      return this.Id;
   }

   public void setId(Long Id) {
      this.Id = Id;
   }

   public Peca getPeca() {
      return this.peca;
   }

   public void setPeca(Peca peca) {
      this.peca = peca;
   }

   public Produto getProduto() {
      return this.produto;
   }

   public void setProduto(Produto produto) {
      this.produto = produto;
   }

}
