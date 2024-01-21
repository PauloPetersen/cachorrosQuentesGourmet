package br.com.cachorrosquentesgourmet.service;

import br.com.cachorrosquentesgourmet.domain.Lanche;
import br.com.cachorrosquentesgourmet.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LancheService {

    @Autowired
    private LancheRepository lancheRepository;

    public List<Lanche> obterTodos() {
        return lancheRepository.findAll();
    }

    public Lanche obterPorId(Long id) {
        Optional<Lanche> lancheOptional = lancheRepository.findById(id);

        return lancheOptional.orElseThrow(() -> new EntityNotFoundException("Lanche não encontrado com o ID: " + id));
    }

    public Lanche criar(Lanche lanche) {
        return lancheRepository.save(lanche);
    }

    public Lanche atualizar(Long id, Lanche lancheAtualizado) {
        Lanche lancheExistente = obterPorId(id);
        lancheExistente.setNomeLanche(lancheAtualizado.getNomeLanche());

        // Se necessário, adicione lógica de atualização adicional aqui

        return lancheRepository.save(lancheExistente);
    }

    public void excluir(Long id) {
        lancheRepository.deleteById(id);
    }
}