package br.com.cachorrosquentesgourmet.service;

import br.com.cachorrosquentesgourmet.domain.ReceitaLanchePadrao;
import br.com.cachorrosquentesgourmet.repository.ReceitaLanchePadraoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaLanchePadraoServiceImpl implements ReceitaLanchePadraoService{
    @Autowired
    private ReceitaLanchePadraoRepository receitaLanchePadraoRepository;

    @Override
    public ReceitaLanchePadrao salvarReceitaLanchePadrao(ReceitaLanchePadrao receitaLanchePadrao) {
        return receitaLanchePadraoRepository.save(receitaLanchePadrao);
    }

    @Override
    public ReceitaLanchePadrao obterReceitaLanchePadraoPorId(Long id) {
        return receitaLanchePadraoRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReceitaLanchePadrao> obterTodasAsReceitasLanchePadrao() {
        return receitaLanchePadraoRepository.findAll();
    }

    @Override
    public void excluirReceitaLanchePadrao(Long id) {
        receitaLanchePadraoRepository.deleteById(id);
    }
}
