package br.com.cachorrosquentesgourmet.domain;

public class LanchePadrao extends Lanche{
    public boolean validar() {
        setId(0L);
        return isLanche();
    }
}
