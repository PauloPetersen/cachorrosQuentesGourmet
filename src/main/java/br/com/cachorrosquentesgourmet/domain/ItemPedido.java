package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;
@Entity
@Table(name = "item_pedido")
public class ItemPedido {
    @Id
    @Column(name = "id_item_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "id_lanche")
    private Lanche lanche;
    @Column(name = "quantidade_lanche_item_pedido")
    private Integer quantidadeLanche;

    public ItemPedido() {
    }

    public ItemPedido(Long id, Pedido pedido, Lanche lanche, Integer quantidadeLanche) {
        this.id = id;
        this.pedido = pedido;
        this.lanche = lanche;
        this.quantidadeLanche = quantidadeLanche;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public Integer getQuantidadeLanche() {
        return quantidadeLanche;
    }

    public void setQuantidadeLanche(Integer quantidadeLanche) {
        this.quantidadeLanche = quantidadeLanche;
    }
}
