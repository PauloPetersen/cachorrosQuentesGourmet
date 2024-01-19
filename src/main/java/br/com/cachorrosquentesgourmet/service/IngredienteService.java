package br.com.cachorrosquentesgourmet.service;

import java.util.List;
import java.util.Optional;

import br.com.cachorrosquentesgourmet.domain.Ingrediente;
import br.com.cachorrosquentesgourmet.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> obterTodas() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente buscaPorId(Long id) {
        Optional<Ingrediente> Ingrediente = ingredienteRepository.findById(id);

        return Ingrediente.get();
    }

}
