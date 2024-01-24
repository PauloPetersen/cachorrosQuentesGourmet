package br.com.cachorrosquentesgourmet.domain;


public class Ingrediente extends Produto {

    public boolean validar() {
        return (isIngrediente() && !isCalculado());
    }

    public Ingrediente() {
    }
    public Ingrediente(Produto produto) {
        setNome(produto.getNome());
        setValor(produto.obterValor());
        setCalculado(produto.isCalculado());
        setIngrediente(produto.isIngrediente());
        setId(produto.getId());
        setPromocao(produto.isPromocao());
        setLanche(produto.isLanche());
    }
}



////    @Id
////    @Column(name = "id_ingrediente")
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//
//    @Column(name = "valor_promocional_ingrediente", nullable = false)
//    private Double valorPromocional;
//
//    public Ingrediente() {
//    }
//
//    public Double getValorPromocional() {
//        return valorPromocional;
//    }
//
//    public void setValorPromocional(Double valorPromocional) {
//        this.valorPromocional = valorPromocional;
//    }




//_______________________________________________________________
//    @Id
//    @Column(name = "id_ingrediente")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "O nome do ingrediente não pode estar em branco.")
//    @Size(max = 50, message = "O nome do ingrediente não pode exceder 50 caracteres.")
//    @Column(name = "nome_ingrediente", nullable = false)
//    private String nome;
//
//    @NotNull(message = "O valor do ingrediente não pode ser nulo.")
//    @DecimalMin(value = "0.01", message = "O valor do ingrediente deve ser maior que zero.")
//    @Column(name = "valor_ingrediente", nullable = false, precision = 4, scale = 2)
//    private BigDecimal valor;
//
//    @NotNull(message = "A condição de se é ou não é um ingrediente especial não pode ser nula.")
//    @Column(name = "ingrediente_especial_ingrediente")
//    private boolean ingredienteEspecial;
//
//    public Ingrediente() {
//    }
//
//    public Ingrediente(Long id, String nome, BigDecimal valor, boolean ingredienteEspecial) {
//        this.id = id;
//        this.nome = nome;
//        this.valor = valor;
//        this.ingredienteEspecial = ingredienteEspecial;
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
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public BigDecimal getValor() {
//        return valor;
//    }
//
//    public void setValor(BigDecimal valor) {
//        this.valor = valor;
//    }
//
//    public boolean isIngredienteEspecial() {
//        return ingredienteEspecial;
//    }
//
//    public void setIngredienteEspecial(boolean ingredienteEspecial) {
//        this.ingredienteEspecial = ingredienteEspecial;
//    }


