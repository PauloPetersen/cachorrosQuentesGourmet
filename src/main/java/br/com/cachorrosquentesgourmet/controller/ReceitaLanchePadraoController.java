package br.com.cachorrosquentesgourmet.controller;

import br.com.cachorrosquentesgourmet.domain.ReceitaLanchePadrao;
import br.com.cachorrosquentesgourmet.service.ReceitaLanchePadraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas-lanche-padrao")
public class ReceitaLanchePadraoController {

    @Autowired
    private ReceitaLanchePadraoService receitaLanchePadraoService;

    @PostMapping
    public ResponseEntity<ReceitaLanchePadrao> salvarReceitaLanchePadrao(@RequestBody ReceitaLanchePadrao receitaLanchePadrao) {
        ReceitaLanchePadrao novaReceita = receitaLanchePadraoService.salvarReceitaLanchePadrao(receitaLanchePadrao);
        return new ResponseEntity<>(novaReceita, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaLanchePadrao> obterReceitaLanchePadrao(@PathVariable Long id) {
        ReceitaLanchePadrao receitaLanchePadrao = receitaLanchePadraoService.obterReceitaLanchePadraoPorId(id);
        return receitaLanchePadrao != null ?
                new ResponseEntity<>(receitaLanchePadrao, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ReceitaLanchePadrao>> obterTodasAsReceitasLanchePadrao() {
        List<ReceitaLanchePadrao> receitas = receitaLanchePadraoService.obterTodasAsReceitasLanchePadrao();
        return new ResponseEntity<>(receitas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirReceitaLanchePadrao(@PathVariable Long id) {
        receitaLanchePadraoService.excluirReceitaLanchePadrao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
