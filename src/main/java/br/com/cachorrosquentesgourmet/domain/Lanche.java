package br.com.cachorrosquentesgourmet.domain;

import java.util.List;

public class Lanche extends Produto {

    private List<Ingrediente> ingredientes;

    public boolean validar() {
        return isLanche();
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public Double calcularValor() {
        if (!isCalculado()) {
            return getValor();
        }

        double valorTotal = 0;
        for (Ingrediente ingrediente : ingredientes) {
            valorTotal += ingrediente.obterValor();
        }

        return valorTotal;
    }
}
