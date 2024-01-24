package br.com.cachorrosquentesgourmet.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LancheCustomizado extends Lanche {

    public boolean validar() {
        setId(0L);
        return isLanche();
    }
}
