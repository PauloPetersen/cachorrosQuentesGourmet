package br.com.cachorrosquentesgourmet.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    @Column(name = "id_ingrediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome do ingrediente não pode estar em branco.")
    @Size(max = 50, message = "O nome do ingrediente não pode exceder 50 caracteres.")
    @Column(name = "nome_ingrediente", nullable = false)
    private String nome;
    @NotNull(message = "O valor do ingrediente não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O valor do ingrediente deve ser maior que zero.")
    @Column(name = "valor_ingrediente", nullable = false, precision = 4, scale = 2)
    private BigDecimal valor;

    public Ingrediente() {
    }

    public Ingrediente(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}

