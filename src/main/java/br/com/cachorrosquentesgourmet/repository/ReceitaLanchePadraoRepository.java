package br.com.cachorrosquentesgourmet.repository;

import br.com.cachorrosquentesgourmet.domain.ReceitaLanchePadrao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaLanchePadraoRepository extends JpaRepository<ReceitaLanchePadrao, Long> {

}
