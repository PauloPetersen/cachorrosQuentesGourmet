package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;

public class ItemPromocao {

    private Produto produto;
    private Double porcentagemDesconto;

    public ItemPromocao(Produto produto, Double porcentagemDesconto) {
        this.produto = produto;
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(Double porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }
}

//@Entity
//@Table(name = "item_promocao")
//public class ItemPromocao {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_promocao")
//    private Promocao promocao;
//
//    @ManyToOne
//    @JoinColumn(name = "id_lanche")
//    private Lanche lanche;
//
//    @ManyToOne
//    @JoinColumn(name = "id_produto")
//    private Produto produto;
//
//    @Column(name = "id_valor")
//    private Double valor;
//
//    public ItemPromocao() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Promocao getPromocao() {
//        return promocao;
//    }
//
//    public void setPromocao(Promocao promocao) {
//        this.promocao = promocao;
//    }
//
//    public Lanche getLanche() {
//        return lanche;
//    }
//
//    public void setLanche(Lanche lanche) {
//        this.lanche = lanche;
//    }
//
//    public Produto getProduto() {
//        return produto;
//    }
//
//    public void setProduto(Produto produto) {
//        this.produto = produto;
//    }
//
//    public Double getValor() {
//        return valor;
//    }
//
//    public void setValor(Double valor) {
//        this.valor = valor;
//    }
//}

//_________________________________________

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_item_promocao")
//    private Long id;
//
//    private Lanche lanche;
//    @Column(name = "quantidade_lanche_item_promocao")
//    private Integer quantidadeLanche;
//
//    public ItemPromocao() {
//    }
//
//    public ItemPromocao(Long id, Lanche lanche, Integer quantidadeLanche) {
//        this.id = id;
//        this.lanche = lanche;
//        this.quantidadeLanche = quantidadeLanche;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Lanche getLanche() {
//        return lanche;
//    }
//
//    public void setLanche(Lanche lanche) {
//        this.lanche = lanche;
//    }
//
//    public Integer getQuantidadeLanche() {
//        return quantidadeLanche;
//    }
//
//    public void setQuantidadeLanche(Integer quantidadeLanche) {
//        this.quantidadeLanche = quantidadeLanche;
//    }

