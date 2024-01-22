package br.com.cachorrosquentesgourmet.controller;

import br.com.cachorrosquentesgourmet.domain.Lanche;
import br.com.cachorrosquentesgourmet.service.LancheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/lanche")
public class LancheController {

    @Autowired
    private LancheService lancheService;

    @GetMapping
    public ResponseEntity<List<Lanche>> obterTodosLanches() {
        List<Lanche> lanches = lancheService.obterTodos();
        return new ResponseEntity<>(lanches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lanche> obterLanchePorId(@PathVariable Long id) {
        Lanche lanche = lancheService.obterPorId(id);
        return new ResponseEntity<>(lanche, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lanche> criarLanche(@RequestBody Lanche lanche) {
        Lanche novoLanche = lancheService.criar(lanche);
        return new ResponseEntity<>(novoLanche, HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Lanche> atualizarLanche(@PathVariable Long id, @RequestBody Lanche lanche) {
//        Lanche lancheAtualizado = lancheService.atualizar(id, lanche);
//        return new ResponseEntity<>(lancheAtualizado, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLanche(@PathVariable Long id) {
        lancheService.excluirLanche(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{idLanche}/ingredientes/{idIngrediente}")
    public ResponseEntity<Lanche> excluirIngrediente(@PathVariable Long idLanche, @PathVariable Long idIngrediente) {
        try {
            Lanche lancheAtualizado = lancheService.excluirIngrediente(idLanche, idIngrediente);
            return ResponseEntity.ok(lancheAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
