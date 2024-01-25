package br.com.cachorrosquentesgourmet.domain;

import java.util.*;

public class Promocao extends Produto {

    private List<ItemPromocao> itens;

    public boolean validar() {
        return isPromocao();
    }

    public List<ItemPromocao> getItens() {
        if (itens == null) {
            itens = new ArrayList<ItemPromocao>();
        }
        return itens;
    }

    public void setItens(List<ItemPromocao> itens) {
        this.itens = itens;
    }

    public Promocao() {
    }

    public Promocao(Produto produto){
        setNome(produto.getNome());
        setValor(produto.obterValor());
        setCalculado(produto.isCalculado());
        setIngrediente(produto.isIngrediente());
        setId(produto.getId());
        setPromocao(produto.isPromocao());
        setLanche(produto.isLanche());
    }

    public Double calcularValor() {
        if (!isCalculado()) {
            return getValor();
        }

        double valorTotal = 0;
        for (ItemPromocao item : itens) {
            double valor = item.getProduto().obterValor();
            double desconto = item.getPorcentagemDesconto();

            if (desconto == 0) {
                valorTotal += valor;
            } else {
                valorTotal += valor - (valor*desconto / 100);
            }
        }

        return valorTotal;
    }
}
