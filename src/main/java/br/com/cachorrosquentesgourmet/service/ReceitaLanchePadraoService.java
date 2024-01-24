package br.com.cachorrosquentesgourmet.service;

import br.com.cachorrosquentesgourmet.domain.ReceitaLanchePadrao;

import java.util.List;

public interface ReceitaLanchePadraoService {
    ReceitaLanchePadrao salvarReceitaLanchePadrao(ReceitaLanchePadrao receitaLanchePadrao);
    ReceitaLanchePadrao obterReceitaLanchePadraoPorId(Long id);
    List<ReceitaLanchePadrao> obterTodasAsReceitasLanchePadrao();
    void excluirReceitaLanchePadrao(Long id);
}
