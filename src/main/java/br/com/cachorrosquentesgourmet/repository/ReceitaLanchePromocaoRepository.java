package br.com.cachorrosquentesgourmet.repository;

import br.com.cachorrosquentesgourmet.domain.ReceitaLanchePromocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaLanchePromocaoRepository extends JpaRepository<ReceitaLanchePromocao, Long> {

}
