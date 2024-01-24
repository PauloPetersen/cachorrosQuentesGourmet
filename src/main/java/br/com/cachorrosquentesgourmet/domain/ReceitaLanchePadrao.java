package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;

@Entity
@Table(name = "RECEITA_LANCHE_PADRAO")
public class ReceitaLanchePadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO_MASTER")
    private Produto produtoMaster;

    @Column(name = "ID_PRODUTO_INGREDIENTE")
    private Long idProdutoIngrediente;

    public ReceitaLanchePadrao() {
    }

    public ReceitaLanchePadrao(Produto produtoMaster, Long idProdutoIngrediente) {
        this.produtoMaster = produtoMaster;
        this.idProdutoIngrediente = idProdutoIngrediente;
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

    public Long getIdProdutoIngrediente() {
        return idProdutoIngrediente;
    }

    public void setIdProdutoIngrediente(Long idProdutoIngrediente) {
        this.idProdutoIngrediente = idProdutoIngrediente;
    }
}