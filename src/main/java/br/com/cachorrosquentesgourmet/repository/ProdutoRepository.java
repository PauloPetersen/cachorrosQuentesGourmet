package br.com.cachorrosquentesgourmet.repository;

import br.com.cachorrosquentesgourmet.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByIsLancheFalseAndIsPromocaoFalseAndIsIngredienteFalseAndIsCalculadoFalse();

}
