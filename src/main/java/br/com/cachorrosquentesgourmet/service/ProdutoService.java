package br.com.cachorrosquentesgourmet.service;

import br.com.cachorrosquentesgourmet.domain.*;
import br.com.cachorrosquentesgourmet.dtos.LancheCustomizadoDTO;
import br.com.cachorrosquentesgourmet.dtos.LanchePadraoDTO;
import br.com.cachorrosquentesgourmet.domain.Lanche;
import br.com.cachorrosquentesgourmet.dtos.ListaIdsRequest;
import br.com.cachorrosquentesgourmet.interfaces.IProdutoService;
import br.com.cachorrosquentesgourmet.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvarProduto(Produto produto) {
        try {
            validarProduto(produto);
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

//    @Transactional
//    public Produto atualizarProduto(Long produtoId, Produto novoProduto) {
//        validarProduto(novoProduto);
//        Produto produtoExistente = obterProduto(produtoId);
//        atualizarAtributos(produtoExistente, novoProduto);
//        return produtoRepository.save(produtoExistente);
//    }


    @Transactional
    public Produto atualizarLancheCustomizado(Long produtoId, Produto novoProduto) {
        validarProduto(novoProduto);
        Produto produtoExistente = obterProduto(produtoId);
        atualizarAtributos(produtoExistente, novoProduto);
        if (produtoExistente instanceof Lanche) {
            atualizarIngredientes((Lanche) produtoExistente, ((Lanche) novoProduto).getIngredientes());
        }
        return produtoRepository.save(produtoExistente);
    }

    public void atualizarIngredientes(Produto produtoExistente, List<Ingrediente> novosIngredientes) {
        if (produtoExistente instanceof Lanche) {
            Lanche lanche = (Lanche) produtoExistente;

            lanche.setIngredientes(novosIngredientes);
        }
    }

    private void validarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }

        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode estar vazio.");
        }

        if (produto.getValor() == null || produto.getValor() <= 0) {
            throw new IllegalArgumentException("O valor do produto deve ser maior que zero.");
        }
    }

//    private void validarValorDoProduto(Double valor) {
//        if (valor == null || valor <= 0) {
//            throw new IllegalArgumentException("O valor deve ser especificado e maior que zero.");
//        }
//    }

    private void atualizarAtributos(Produto destino, Produto origem) {
        // VERIFICAR
        destino.setNome(origem.getNome());
        destino.setValor(origem.getValor());
        destino.setIngrediente(origem.isIngrediente());
        destino.setLanche(origem.isLanche());
        destino.setPromocao(origem.isPromocao());
        destino.setCalculado(origem.isCalculado());
    }

    public Double calcularValorDoLanchePadrao(LanchePadrao lanchePadrao) {
        return new LanchePadraoDTO(lanchePadrao.getNome(), lanchePadrao.calcularValor()).getValor();
    }

    public Double calcularValorDoLancheCustomizado(LancheCustomizado lancheCustomizado) {
        return new LancheCustomizadoDTO(lancheCustomizado.getNome(), lancheCustomizado.calcularValor()).getValor();
    }

    public LancheCustomizado atualizarLancheCustomizado(ListaIdsRequest request) {
        // { "request" : [2, 3, 5]}
        LancheCustomizado lancheCustomizado = new LancheCustomizado();
        lancheCustomizado.setLanche(true);
        lancheCustomizado.setCalculado(true);
        lancheCustomizado.setPromocao(false);
        lancheCustomizado.setIngrediente(false);
        lancheCustomizado.setNome("Meu lanche customizado");

        for (Long id : request.getListaIds()) {
            Produto produtoIngrediente = obterProduto(id);
            if (produtoIngrediente != null && produtoIngrediente.isIngrediente()) {
                Ingrediente ingrediente = new Ingrediente(produtoIngrediente);
                lancheCustomizado.getIngredientes().add(ingrediente);
            }
        }

        lancheCustomizado.setValor(lancheCustomizado.obterValor());

        return lancheCustomizado;
    }

}
