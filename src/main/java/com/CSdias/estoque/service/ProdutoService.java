package com.CSdias.estoque.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CSdias.estoque.model.IProdutoRepository;
import com.CSdias.estoque.model.Pedido;
import com.CSdias.estoque.model.Produto;

@Service
public class ProdutoService implements IProdutoService{
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IProdutoRepository produtoRepository;

    @Override
    public List<Produto> consultaProduto() {
        logger.info(">>> Serviço consulta 'Produto' iniciado");

        List<Produto> produto = produtoRepository.findAll();

        return produto;
    }

    @Override
    public List<Produto> consultaPorNome(String nome) {
        logger.info(">>> Serviço 'Produto' consultaPorNome iniciado");

        List<Produto> produto = produtoRepository.findByNomeIgnoringCaseContaining(nome);

        return produto;
    }

    @Override
    public List<Produto> consultaPorPedido(Set<Pedido> pedido) {
        logger.info(">>> Serviço 'Produto' consultaPorPedido inciado");

        List<Produto> produto = produtoRepository.findByPedido(pedido);

        return produto;
    }

    @Override
    public Optional<Produto> consultarPorID(Long id) {
        logger.info(">>> Serviço 'Produto' cosultaPorId iniciado");

        Optional<Produto> produto = produtoRepository.findById(id);

        return produto;
    }

    @Override
    public Optional<Produto> cadastrarProduto(Produto produto) {
        logger.info(">>> Serviço 'Produto' cadastrarProduto iniciado");

        return Optional.ofNullable(produtoRepository.save(produto));
    }

    @Override
    public Optional<Produto> atualizarProduto(Produto newProduto) {
        logger.info(">>> Serviço 'Produto' atualizarProduto iniciado");

        return produtoRepository.findById(newProduto.getId()).map(produto -> {
            produto.setCor(newProduto.getCor());
            produto.setDescricao(newProduto.getDescricao());
            produto.setModelo(newProduto.getModelo());
            produto.setNome(newProduto.getNome());
            produto.setValorUnitario(newProduto.getValorUnitario());

            return produtoRepository.save(produto);
        });
    }

    @Override
    public void excluirProduto(Long id) {
        logger.info(">>> Serviço 'Produto' excluirProduto iniciado");

        produtoRepository.deleteById(id);
    }
}
