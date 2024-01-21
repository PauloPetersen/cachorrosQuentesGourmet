package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @OneToMany
    @JoinTable(name = "pedido_lanche",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_ingrediente"))
    private List<ItemPedido> itemPedido = new ArrayList<>();

    @Column(name = "preco_total_pedido", nullable = false, precision = 4, scale = 2)
    private BigDecimal precoTotal;

    public Pedido() {
    }

    public Pedido(Long id, List<ItemPedido> itemPedido, BigDecimal precoTotal) {
        this.id = id;
        this.itemPedido = itemPedido;
        this.precoTotal = precoTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }
}
