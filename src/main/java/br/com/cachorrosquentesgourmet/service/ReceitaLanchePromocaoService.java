package br.com.cachorrosquentesgourmet.service;

import br.com.cachorrosquentesgourmet.domain.ItemPromocao;
import br.com.cachorrosquentesgourmet.domain.Produto;
import br.com.cachorrosquentesgourmet.domain.Promocao;
import br.com.cachorrosquentesgourmet.service.ProdutoService;
import br.com.cachorrosquentesgourmet.domain.ReceitaLanchePromocao;
import br.com.cachorrosquentesgourmet.repository.ProdutoRepository;
import br.com.cachorrosquentesgourmet.repository.ReceitaLanchePromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaLanchePromocaoService {

    private final ReceitaLanchePromocaoRepository receitaRepository;
    private final ProdutoRepository produtoRepository;

    private final ProdutoService produtoService;

    @Autowired
    public ReceitaLanchePromocaoService(ReceitaLanchePromocaoRepository receitaRepository, ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.receitaRepository = receitaRepository;
        this.produtoService = produtoService;
    }

    public List<ReceitaLanchePromocao> listarReceitas() {
        return receitaRepository.findAll();
    }

    public Optional<ReceitaLanchePromocao> obterReceitaPorId(Long id) {
        return receitaRepository.findById(id);
    }


    public Promocao criarReceita(List<ReceitaLanchePromocao> receitas) {
        Promocao promocao = null;

        for (ReceitaLanchePromocao item : receitas) {
            if (promocao == null) {
                promocao = new Promocao(produtoService.obterProduto(item.getProdutoMaster().getId()));
            }

            if (promocao != null) {
                Produto produtoPromocao = produtoService.obterProduto(item.getIdItemPromocao());
                ItemPromocao itemPromocao = new ItemPromocao(produtoPromocao, item.getDescontoItemPorcentagem());
                promocao.getItens().add(itemPromocao);
            }
        }

        promocao.setValor(promocao.obterValor());
        return promocao;
    }

    public ReceitaLanchePromocao atualizarReceita(Long id, ReceitaLanchePromocao receitaAtualizada) {
        return receitaRepository.save(receitaAtualizada);
    }

    public void deletarReceita(Long id) {
        receitaRepository.deleteById(id);
    }
}
