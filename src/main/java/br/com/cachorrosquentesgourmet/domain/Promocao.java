package br.com.cachorrosquentesgourmet.domain;

import java.util.List;

public class Promocao extends Produto {

    private List<ItemPromocao> itens;

    public boolean validar() {
        return isPromocao();
    }

    public List<ItemPromocao> getItens() {
        return itens;
    }

    public void setItens(List<ItemPromocao> itens) {
        this.itens = itens;
    }

    public Double calcularValor() {
        if (!isCalculado()) {
            return getValor();
        }

        double valorTotal = 0;
        for (ItemPromocao item : itens) {
            double valor = item.getProduto().obterValor();
            double desconto = item.getPorcentagemDesconto();

            if (desconto == 0) {
                valorTotal += valor;
            } else {
                valorTotal += valor * (desconto / 100);
            }
        }

        return valorTotal;
    }
}


//@Entity
//@Table(name = "promocao")
//public class Promocao {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "nome")
//    private String nome;
//
//    @Column(name = "desconto")
//    private Double desconto;
//
//    @OneToMany(mappedBy = "promocao", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ItemPromocao> itens;
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
//    public Double getDesconto() {
//        return desconto;
//    }
//
//    public void setDesconto(Double desconto) {
//        this.desconto = desconto;
//    }
//
//    public List<ItemPromocao> getItens() {
//        return itens;
//    }
//
//    public void setItens(List<ItemPromocao> itens) {
//        this.itens = itens;
//    }
//}

//_____________________________________

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_promocao")
//    private Long id;
//    @Column(name = "nome_promocao_promocao")
//    private String nomePromocao;
//
//    @ManyToOne
//    @JoinColumn(name = "id_lanche")
//    private List<Lanche> lanche;
//
//    public Promocao() {
//    }
//
//    public Promocao(Long id, String nomePromocao, List<Lanche> lanche) {
//        this.id = id;
//        this.nomePromocao = nomePromocao;
//        this.lanche = lanche;
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
//    public String getNomePromocao() {
//        return nomePromocao;
//    }
//
//    public void setNomePromocao(String nomePromocao) {
//        this.nomePromocao = nomePromocao;
//    }
//
//    public List<Lanche> getLanche() {
//        return lanche;
//    }
//
//    public void setLanche(List<Lanche> lanche) {
//        this.lanche = lanche;
//    }

