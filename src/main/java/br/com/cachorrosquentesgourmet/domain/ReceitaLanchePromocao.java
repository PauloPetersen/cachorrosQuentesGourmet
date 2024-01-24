package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;

@Entity
@Table(name = "RECEITA_LANCHE_PROMOCAO")
public class ReceitaLanchePromocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO_MASTER")
    private Produto produtoMaster;

    @Column(name = "ID_ITEM_PROMOCAO")
    private Long idItemPromocao;

    @Column(name = "DESCONTO_ITEM_PORCENTAGEM")
    private Integer descontoItemPorcentagem;

    public ReceitaLanchePromocao() {
    }

    public ReceitaLanchePromocao(Produto produtoMaster, Long idItemPromocao, Integer descontoItemPorcentagem) {
        this.produtoMaster = produtoMaster;
        this.idItemPromocao = idItemPromocao;
        this.descontoItemPorcentagem = descontoItemPorcentagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProdutoMaster() {
        return produtoMaster;
    }

    public void setProdutoMaster(Produto produtoMaster) {
        this.produtoMaster = produtoMaster;
    }

    public Long getIdItemPromocao() {
        return idItemPromocao;
    }

    public void setIdItemPromocao(Long idItemPromocao) {
        this.idItemPromocao = idItemPromocao;
    }

    public Integer getDescontoItemPorcentagem() {
        return descontoItemPorcentagem;
    }

    public void setDescontoItemPorcentagem(Integer descontoItemPorcentagem) {
        this.descontoItemPorcentagem = descontoItemPorcentagem;
    }
}
