package br.com.cachorrosquentesgourmet.service;

import br.com.cachorrosquentesgourmet.domain.Ingrediente;
import br.com.cachorrosquentesgourmet.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> obterTodos() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente obterPorId(Long id) {
        return ingredienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingrediente não encontrado com o ID: " + id));
    }

    public Ingrediente criar(Ingrediente ingrediente) {
        validarIngrediente(ingrediente);

        ingrediente.setNome(padronizarNome(ingrediente.getNome()));

        return ingredienteRepository.save(ingrediente);
    }

    public Ingrediente atualizar(Long id, Ingrediente ingredienteAtualizado) {
        Ingrediente ingredienteExistente = obterPorId(id);
        validarIngrediente(ingredienteAtualizado);
        copiarValores(ingredienteExistente, ingredienteAtualizado);
        return ingredienteRepository.save(ingredienteExistente);
    }

    public void excluir(Long id) {
        ingredienteRepository.deleteById(id);
    }

    private void validarIngrediente(Ingrediente ingrediente) {
        Objects.requireNonNull(ingrediente, "Ingrediente não pode ser nulo.");
        validarValorIngrediente(ingrediente.getValor());
        validarNomeIngrediente(ingrediente.getNome());
    }

    private void validarValorIngrediente(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do ingrediente deve ser especificado e maior que zero.");
        }
    }

    private void validarNomeIngrediente(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do ingrediente deve ser especificado.");
        }
        String nomePadronizado = padronizarNome(nome);
        if (nomePadronizado.length() > 50) {
            throw new IllegalArgumentException("O nome do ingrediente não pode exceder 50 caracteres.");
        }
        if (ingredienteRepository.existsByNome(nomePadronizado)) {
            throw new IllegalArgumentException("Já existe um ingrediente com o mesmo nome.");
        }
    }

    private void copiarValores(Ingrediente destino, Ingrediente origem) {
        destino.setNome(padronizarNome(origem.getNome()));
        destino.setValor(origem.getValor());
    }

    private String padronizarNome(String nome) {
        if (nome == null) {
            return "";
        }

        return nome.trim()
                .replaceAll("\\s+", " ")
                .replaceAll("[^\\p{L}\\s]", "")
                .toLowerCase();
    }

}
