package br.com.cachorrosquentesgourmet.domain;

public class ItemAvulso extends Produto {

    public boolean validar() {
        return (!isLanche() && !isPromocao() && !isIngrediente() && !isCalculado());
    }
}
