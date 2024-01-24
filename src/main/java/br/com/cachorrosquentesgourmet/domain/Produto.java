package br.com.cachorrosquentesgourmet.domain;

import br.com.cachorrosquentesgourmet.interfaces.IProduto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto implements IProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "IS_INGREDIENTE")
    protected boolean isIngrediente;

    @Column(name = "IS_LANCHE")
    protected boolean isLanche;

    @Column(name = "IS_PROMOCAO")
    protected boolean isPromocao;

    @Column(name = "IS_CALCULADO")
    protected boolean isCalculado;

    public Produto() {
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isIngrediente() {
        return isIngrediente;
    }

    public void setIngrediente(boolean ingrediente) {
        isIngrediente = ingrediente;
    }

    public boolean isLanche() {
        return isLanche;
    }

    public void setLanche(boolean lanche) {
        isLanche = lanche;
    }

    public boolean isPromocao() {
        return isPromocao;
    }

    public void setPromocao(boolean promocao) {
        isPromocao = promocao;
    }

    public boolean isCalculado() {
        return isCalculado;
    }

    public void setCalculado(boolean calculado) {
        isCalculado = calculado;
    }

    public Double calcularValor() {
        return valor;
    }

    public Double obterValor() {
        if (!isCalculado) {
            return valor;
        }
        return calcularValor();
    }
}
