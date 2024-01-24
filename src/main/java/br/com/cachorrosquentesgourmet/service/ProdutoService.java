package br.com.cachorrosquentesgourmet.service;

import br.com.cachorrosquentesgourmet.domain.Produto;
import br.com.cachorrosquentesgourmet.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvarProduto(Produto produto) {
        try {
            validarProduto(produto);
            validarValorDoProduto(produto.getValor());
            return produtoRepository.save(produto);
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao salvar o produto.", e);
        }
    }

    @Transactional
    public Produto obterProduto(Long produtoId) {
        return produtoRepository.findById(produtoId).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + produtoId));
    }

    @Transactional
    public List<Produto> obterTodosProdutos() {
        return produtoRepository.findAll();
    }

    @Transactional
    public void removerProduto(Long produtoId) {
        try {
            produtoRepository.deleteById(produtoId);
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao remover o produto.", e);
        }
    }

    @Transactional
    public Produto atualizarProduto(Long produtoId, Produto novoProduto) {
        Produto produtoExistente = obterProduto(produtoId);
        atualizarAtributos(produtoExistente, novoProduto);
        return produtoRepository.save(produtoExistente);
    }

    private void validarProduto(Produto produto) {
        //FALTA IMPLEMENTAR AQUI
    }

    private void validarValorDoProduto(Double valor) {
        if (valor == null || valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser especificado e maior que zero.");
        }
    }

    private void atualizarAtributos(Produto destino, Produto origem) {
        // VERIFICAR
        destino.setNome(origem.getNome());
        destino.setValor(origem.getValor());
        destino.setIngrediente(origem.isIngrediente());
        destino.setLanche(origem.isLanche());
        destino.setPromocao(origem.isPromocao());
        destino.setCalculado(origem.isCalculado());
    }
}
