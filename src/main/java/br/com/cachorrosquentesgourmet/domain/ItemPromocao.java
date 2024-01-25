package br.com.cachorrosquentesgourmet.domain;

import br.com.cachorrosquentesgourmet.interfaces.IProduto;


public class ItemPromocao {

    private IProduto produto;
    private Integer porcentagemDesconto;

    public ItemPromocao(Produto produto, Integer porcentagemDesconto) {
        this.produto = produto;
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public IProduto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(Integer porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
}

