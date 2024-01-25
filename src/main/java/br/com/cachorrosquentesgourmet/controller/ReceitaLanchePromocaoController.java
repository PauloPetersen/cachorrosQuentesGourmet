package br.com.cachorrosquentesgourmet.controller;

import br.com.cachorrosquentesgourmet.domain.Promocao;
import br.com.cachorrosquentesgourmet.domain.ReceitaLanchePromocao;
import br.com.cachorrosquentesgourmet.service.ReceitaLanchePromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receitas-lanche-promocao")
public class ReceitaLanchePromocaoController {

    private final ReceitaLanchePromocaoService receitaService;

    @Autowired
    public ReceitaLanchePromocaoController(ReceitaLanchePromocaoService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public ResponseEntity<List<ReceitaLanchePromocao>> listarReceitas() {
        List<ReceitaLanchePromocao> receitas = receitaService.listarReceitas();
        return new ResponseEntity<>(receitas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaLanchePromocao> obterReceitaPorId(@PathVariable Long id) {
        Optional<ReceitaLanchePromocao> receita = receitaService.obterReceitaPorId(id);
        return receita.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Promocao> criarReceita(@RequestBody List<ReceitaLanchePromocao> receita) {
        Promocao novaReceita = receitaService.criarReceita(receita);
        return new ResponseEntity<>(novaReceita, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaLanchePromocao> atualizarReceita(@PathVariable Long id,
                                                                  @RequestBody ReceitaLanchePromocao receitaAtualizada) {
        ReceitaLanchePromocao receitaAtualizadaResult = receitaService.atualizarReceita(id, receitaAtualizada);
        return new ResponseEntity<>(receitaAtualizadaResult, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReceita(@PathVariable Long id) {
        receitaService.deletarReceita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}