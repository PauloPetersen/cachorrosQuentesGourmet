package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pessoa")
public class Ingrediente {

    @Id
    @Column(name = "id_ingrediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_ingrediente", nullable = false)
    private String nome;
    @Column(name = "valor_ingrediente", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    public Ingrediente() {
    }

    public Ingrediente(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

