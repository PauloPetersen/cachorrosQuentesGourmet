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

//@Entity
//@Table(name = "lanche")
//@PrimaryKeyJoinColumn(name = "id_lanche")
//public class Lanche extends Produto {
//    @OneToMany(mappedBy = "lanche", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<LancheIngrediente> ingredientes;
//
//    // outros atributos, construtores, getters e setters
//
//    public List<LancheIngrediente> getIngredientes() {
//        return ingredientes;
//    }
//
//    public void setIngredientes(List<LancheIngrediente> ingredientes) {
//        this.ingredientes = ingredientes;
//    }
//
//    public double getValorTotalIngredientes() {
//        double valorTotal = 0;
//        for (LancheIngrediente li : ingredientes) {
//            valorTotal += li.getIngrediente().getValor();
//        }
//        return valorTotal;
//    }
//
//    Lanche() {
//
//    }
//
//}

//_______________________________________

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_lanche")
//    private Long id;
//
//    @Column(name = "nome_lanche_lanche")
//    private String nomeLanche;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "lanche_ingrediente",
//            joinColumns = @JoinColumn(name = "lanche_id_lanche"),
//            inverseJoinColumns = @JoinColumn(name = "ingredientes_id_ingrediente")
//    )
//    private List<Ingrediente> ingredientes;
//    @NotNull(message = "A condição de se é ou não é um lanche customizado não pode ser nula.")
//    @Column(name = "customizado_lanche")
//    private boolean isCustomizado;
//
//    public Lanche() {
//    }
//
//    public Lanche(Long id, String nomeLanche, List<Ingrediente> ingredientes, boolean isCustomizado) {
//        this.id = id;
//        this.nomeLanche = nomeLanche;
//        this.ingredientes = ingredientes;
//        this.isCustomizado = isCustomizado;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNomeLanche() {
//        return nomeLanche;
//    }
//
//    public void setNomeLanche(String nomeLanche) {
//        this.nomeLanche = nomeLanche;
//    }
//
//    public List<Ingrediente> getIngredientes() {
//        return ingredientes;
//    }
//
//    public void setIngredientes(List<Ingrediente> ingredientes) {
//        this.ingredientes = ingredientes;
//    }
//
//    public boolean isCustomizado() {
//        return isCustomizado;
//    }
//
//    public void setCustomizado(boolean customizado) {
//        isCustomizado = customizado;
//
//        if (isCustomizado) {
//            this.nomeLanche = "lanche customizado";
//        }
//    }

