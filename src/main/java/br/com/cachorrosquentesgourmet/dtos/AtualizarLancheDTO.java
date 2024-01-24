package br.com.cachorrosquentesgourmet.dtos;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AtualizarLancheDTO implements Serializable {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nomeLanche")
    private String nomeLanche;

    @JsonProperty("customizado")
    private boolean customizado;

    @JsonProperty("ingredientesIds")
    private List<Long> ingredientesIds;

    public AtualizarLancheDTO() {
    }

    public AtualizarLancheDTO(Long id, String nomeLanche, boolean customizado, List<Long> ingredientesIds) {
        this.id = id;
        this.nomeLanche = nomeLanche;
        this.customizado = customizado;
        this.ingredientesIds = ingredientesIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLanche() {
        return nomeLanche;
    }

    public void setNomeLanche(String nomeLanche) {
        this.nomeLanche = nomeLanche;
    }

    public boolean isCustomizado() {
        return customizado;
    }

    public void setCustomizado(boolean customizado) {
        this.customizado = customizado;
    }

    public List<Long> getIngredientesIds() {
        return ingredientesIds;
    }

    public void setIngredientesIds(List<Long> ingredientesIds) {
        this.ingredientesIds = ingredientesIds;
    }
}
