package br.com.cachorrosquentesgourmet.controller;

import br.com.cachorrosquentesgourmet.domain.Ingrediente;
import br.com.cachorrosquentesgourmet.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public ResponseEntity<List<Ingrediente>> obterTodosIngredientes() {
        List<Ingrediente> ingredientes = ingredienteService.obterTodos();
        return new ResponseEntity<>(ingredientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> obterIngredientePorId(@PathVariable Long id) {
        Ingrediente ingrediente = ingredienteService.obterPorId(id);
        return new ResponseEntity<>(ingrediente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ingrediente> criarIngrediente(@RequestBody Ingrediente ingrediente) {
        Ingrediente novoIngrediente = ingredienteService.criar(ingrediente);
        return new ResponseEntity<>(novoIngrediente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> atualizarIngrediente(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        Ingrediente ingredienteAtualizado = ingredienteService.atualizar(id, ingrediente);
        return new ResponseEntity<>(ingredienteAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirIngrediente(@PathVariable Long id) {
        ingredienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
