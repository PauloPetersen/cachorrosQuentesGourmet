package br.com.cachorrosquentesgourmet.dtos;

import java.util.List;

public class ListaIdsRequest {
    private List<Long> listaIds;

    public List<Long> getListaIds() {
        return listaIds;
    }

    public void setListaIds(List<Long> listaIds) {
        this.listaIds = listaIds;
    }
}