package br.com.cachorrosquentesgourmet.dtos;

public class LancheCustomizadoDTO {

    private String nome;
    private Double valor;

    public LancheCustomizadoDTO() {
    }

    public LancheCustomizadoDTO(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
