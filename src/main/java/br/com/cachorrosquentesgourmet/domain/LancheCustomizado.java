package br.com.cachorrosquentesgourmet.domain;


public class LancheCustomizado extends Lanche {

    public boolean validar() {
        setId(0L);
        return isLanche();
    }
}
