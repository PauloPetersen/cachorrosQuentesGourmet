package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;
import java.util.List;
import br.com.cachorrosquentesgourmet.domain.Ingrediente;

@Entity
@Table(name = "lanche")
public class Lanche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lanche")
    private Long id;

    @Column(name = "nome_lanche_lanche")
    private String nomeLanche;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "lanche_ingrediente",
            joinColumns = @JoinColumn(name = "lanche_id_lanche"),
            inverseJoinColumns = @JoinColumn(name = "ingredientes_id_ingrediente")
    )
    private List<Ingrediente> ingredientes;

    @Column(name = "customizado_lanche")
    private boolean isCustomizado;

    public Lanche() {
    }

    public Lanche(Long id, String nomeLanche, List<Ingrediente> ingredientes, boolean isCustomizado) {
        this.id = id;
        this.nomeLanche = nomeLanche;
        this.ingredientes = ingredientes;
        this.isCustomizado = isCustomizado;
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

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isCustomizado() {
        return isCustomizado;
    }

    public void setCustomizado(boolean customizado) {
        isCustomizado = customizado;

        if (isCustomizado) {
            this.nomeLanche = "lanche customizado";
        }
    }
}
