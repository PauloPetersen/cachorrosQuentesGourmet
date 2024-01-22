package br.com.cachorrosquentesgourmet.repository;

import br.com.cachorrosquentesgourmet.domain.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Long> {
    boolean existsByNomeLanche(String nome);

}
