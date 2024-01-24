package br.com.cachorrosquentesgourmet.dtos;

import br.com.cachorrosquentesgourmet.domain.Produto;

import java.util.List;

public class AtualizarProdutoDTO <T extends Produto>{
    private Long id;
    private String nome;
    private Double valor;
    private List<Long> ingredientesIds;
    private boolean isIngrediente;

    public AtualizarProdutoDTO() {
    }

    public AtualizarProdutoDTO(Long id, String nome, Double valor, List<Long> ingredientesIds, boolean isIngrediente) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ingredientesIds = ingredientesIds;
        this.isIngrediente = isIngrediente;
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

    public List<Long> getIngredientesIds() {
        return ingredientesIds;
    }

    public void setIngredientesIds(List<Long> ingredientesIds) {
        this.ingredientesIds = ingredientesIds;
    }

    public boolean isIngrediente() {
        return isIngrediente;
    }

    public void setIngrediente(boolean ingrediente) {
        isIngrediente = ingrediente;
    }
}
