package br.com.cachorrosquentesgourmet.interfaces;

import br.com.cachorrosquentesgourmet.domain.Ingrediente;
import br.com.cachorrosquentesgourmet.domain.LancheCustomizado;
import br.com.cachorrosquentesgourmet.domain.LanchePadrao;
import br.com.cachorrosquentesgourmet.domain.Produto;

import java.util.List;

public interface IProdutoService {
    Produto salvarProduto(Produto produto);
    Produto obterProduto(Long produtoId);
    List<Produto> obterTodosProdutos();
    void removerProduto(Long produtoId);
    Produto atualizarLancheCustomizado(Long produtoId, Produto novoProduto);
    void atualizarIngredientes(Produto produtoExistente, List<Ingrediente> novosIngredientes);
    Double calcularValorDoLanchePadrao(LanchePadrao lanchePadrao);
    Double calcularValorDoLancheCustomizado(LancheCustomizado lancheCustomizado);
    List<Produto> obterProdutosAvulsos();
}
