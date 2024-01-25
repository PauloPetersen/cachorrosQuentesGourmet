package br.com.cachorrosquentesgourmet.domain;


public class Ingrediente extends Produto {

    public boolean validar() {
        return (isIngrediente() && !isCalculado());
    }

    public Ingrediente() {
    }
    public Ingrediente(Produto produto) {
        setNome(produto.getNome());
        setValor(produto.obterValor());
        setCalculado(produto.isCalculado());
        setIngrediente(produto.isIngrediente());
        setId(produto.getId());
        setPromocao(produto.isPromocao());
        setLanche(produto.isLanche());
    }
}
