package br.com.cachorrosquentesgourmet.controller;

import br.com.cachorrosquentesgourmet.service.IngredienteService;
import br.com.cachorrosquentesgourmet.domain.Ingrediente;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {
    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/todas")
    public ResponseEntity<List<Ingrediente>> obterTodas() {
        List<Ingrediente> ingrediente = ingredienteService.obterTodas();
        return ResponseEntity.ok(ingrediente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> buscarIngrediente(@PathVariable Long id) {
        Ingrediente ingrediente = ingredienteService.buscaPorId(id);
        return ResponseEntity.ok(ingrediente);

    }
}
