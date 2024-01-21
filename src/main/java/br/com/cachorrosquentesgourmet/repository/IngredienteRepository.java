package br.com.cachorrosquentesgourmet.repository;


import br.com.cachorrosquentesgourmet.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository <Ingrediente, Long> {
    boolean existsByNome(String nome);
}
