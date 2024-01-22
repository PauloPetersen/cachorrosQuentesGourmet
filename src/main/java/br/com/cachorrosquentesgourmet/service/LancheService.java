package br.com.cachorrosquentesgourmet.service;

import br.com.cachorrosquentesgourmet.domain.Ingrediente;
import br.com.cachorrosquentesgourmet.domain.Lanche;
import br.com.cachorrosquentesgourmet.repository.IngredienteRepository;
import br.com.cachorrosquentesgourmet.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class LancheService {

    @Autowired
    private LancheRepository lancheRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Lanche> obterTodos() {
        return lancheRepository.findAll();
    }

    public Lanche obterPorId(Long id) {
        return lancheRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lanche não encontrado com o ID: " + id));
    }

    public Lanche criar(Lanche lanche) {
        validarLanche(lanche);
        lanche.setNomeLanche(padronizarNome(lanche.getNomeLanche()));

        List<Ingrediente> ingredientesPersistidos = validarEAssociarIngredientes(lanche.getIngredientes());
        lanche.setIngredientes(ingredientesPersistidos);

        return lancheRepository.save(lanche);
    }

////    public Lanche atualizar(Long id, Lanche lancheAtualizado) {
////        Lanche lancheExistente = obterPorId(id);
////        validarLanche(lancheAtualizado);
////        associarIngredientes(lancheExistente, lancheAtualizado.getIngredientes());
////        copiarValores(lancheExistente, lancheAtualizado);
////        return lancheRepository.save(lancheExistente);
//    }

    public void excluirLanche(Long id) {
        Lanche lanche = lancheRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lanche não encontrado com o ID: " + id));

        lanche.getIngredientes().clear();

        lancheRepository.deleteById(id);
    }

    public Lanche excluirIngrediente(Long idLanche, Long idIngrediente) {
        Lanche lanche = obterPorId(idLanche);

        if (lanche == null) {
            throw new EntityNotFoundException("Lanche não encontrado com o ID: " + idLanche);
        }

        boolean ingredienteRemovido = lanche.getIngredientes().removeIf(ingrediente -> ingrediente.getId().equals(idIngrediente));

        if (!ingredienteRemovido) {
            throw new IllegalArgumentException("Ingrediente não encontrado no lanche com o ID: " + idLanche);
        }

        return lancheRepository.save(lanche);
    }

    private void validarLanche(Lanche lanche) {
        Objects.requireNonNull(lanche, "Lanche não pode ser nulo.");
        validarNomeLanche(lanche.getNomeLanche(), lanche.isCustomizado());
        validarIngredientes(lanche.getIngredientes());
    }

    private void validarNomeLanche(String nomeLanche, boolean isCustomizado) {
        if (!isCustomizado) {
            if (nomeLanche == null || nomeLanche.trim().isEmpty()) {
                throw new IllegalArgumentException("O nome do lanche deve ser especificado.");
            }
            String nomePadronizado = padronizarNome(nomeLanche);
            if (nomePadronizado.length() > 50) {
                throw new IllegalArgumentException("O nome do lanche não pode exceder 50 caracteres.");
            }
            if (lancheRepository.existsByNomeLanche(nomePadronizado)) {
                throw new IllegalArgumentException("Já existe um lanche com o mesmo nome.");
            }
        }
    }

//    private void associarIngredientes(Lanche lancheExistente, List<Ingrediente> novosIngredientes) {
//        List<Ingrediente> ingredientesPersistidos = new ArrayList<>();
//
//        for (Ingrediente ingrediente : novosIngredientes) {
//            // Busca o ingrediente correspondente na tabela Ingrediente pelo ID
//            Optional<Ingrediente> ingredientePersistidoOptional = ingredienteRepository.findById(ingrediente.getId());
//
//            if (!ingredientePersistidoOptional.isPresent()) {
//                throw new IllegalArgumentException("Ingrediente não encontrado com o ID: " + ingrediente.getId());
//            }
//
//            Ingrediente ingredientePersistido = ingredientePersistidoOptional.get();
//            ingredientesPersistidos.add(ingredientePersistido);
//        }
//
//        lancheExistente.setIngredientes(ingredientesPersistidos);
//    }

    private void validarIngredientes(List<Ingrediente> ingredientes) {
        if (ingredientes != null && !ingredientes.isEmpty()) {
            for (Ingrediente ingrediente : ingredientes) {
                if (ingrediente.getId() == null) {
                    throw new IllegalArgumentException("Os ingredientes devem ter IDs válidos.");
                }
                if (!ingredienteRepository.existsById(ingrediente.getId())) {
                    throw new EntityNotFoundException("Ingrediente não encontrado com o ID: " + ingrediente.getId());
                }
            }
        }
    }

    private List<Ingrediente> validarEAssociarIngredientes(List<Ingrediente> ingredientes) {
        List<Ingrediente> ingredientesPersistidos = new ArrayList<>();
        for (Ingrediente ingrediente : ingredientes) {
            Ingrediente ingredientePersistido = ingredienteRepository.findById(ingrediente.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Ingrediente não encontrado com o ID: " + ingrediente.getId()));
            ingredientesPersistidos.add(ingredientePersistido);
        }
        return ingredientesPersistidos;
    }

//    private void copiarValores(Lanche destino, Lanche origem) {
//        destino.setNomeLanche(padronizarNome(origem.getNomeLanche()));
//        destino.setIngredientes(origem.getIngredientes());
//        destino.setCustomizado(origem.isCustomizado());
//    }

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