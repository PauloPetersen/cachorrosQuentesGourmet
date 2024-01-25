package br.com.cachorrosquentesgourmet.controller;

import br.com.cachorrosquentesgourmet.domain.*;
import br.com.cachorrosquentesgourmet.dtos.LancheCustomizadoDTO;
import br.com.cachorrosquentesgourmet.dtos.LanchePadraoDTO;
import br.com.cachorrosquentesgourmet.dtos.ListaIdsRequest;
import br.com.cachorrosquentesgourmet.service.ProdutoService;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody String json) {
        Produto produtoDB = new Gson().fromJson(json, Produto.class);
        try {
            Produto novoProduto = produtoService.salvarProduto(produtoDB);
            return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produto> obterProduto(@PathVariable Long produtoId) {
        Produto produto = produtoService.obterProduto(produtoId);
        if (produto != null) {
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodosProdutos() {
        List<Produto> produtos = produtoService.obterTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/avulsos")
    public ResponseEntity<List<Produto>> obterProdutosAvulsos() {
        List<Produto> produtosAvulsos = produtoService.obterProdutosAvulsos();
        return new ResponseEntity<>(produtosAvulsos, HttpStatus.OK);
    }

    @PostMapping("/atualizar-lanche-customizado")
    public ResponseEntity<LancheCustomizado> atualizarLancheCustomizado(@RequestBody String json) {
        try {
            ListaIdsRequest listaIngredientes = new Gson().fromJson(json, ListaIdsRequest.class);
            LancheCustomizado produtoAtualizado = produtoService.atualizarLancheCustomizado(listaIngredientes);
            return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
        } catch (JsonSyntaxException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> removerProduto(@PathVariable Long produtoId) {
        produtoService.removerProduto(produtoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/criar-lanche-customizado")
    public ResponseEntity<LancheCustomizadoDTO> criarLancheCustomizado(@RequestBody String json) {
        LancheCustomizado lancheCustomizado = new Gson().fromJson(json, LancheCustomizado.class);

        LancheCustomizadoDTO lancheCustomizadoDTO = new LancheCustomizadoDTO(lancheCustomizado.getNome(), lancheCustomizado.calcularValor());
        Double valorCalculado = produtoService.calcularValorDoLancheCustomizado(lancheCustomizado);

        return ResponseEntity.ok(lancheCustomizadoDTO);
    }

        @PostMapping("/criar-lanche-padrao")
        public ResponseEntity<LanchePadraoDTO> criarLanchePadrao (@RequestBody String json){
            LanchePadrao lanchePadrao = new Gson().fromJson(json, LanchePadrao.class);
            LanchePadraoDTO lanchePadraoDTO = new LanchePadraoDTO(lanchePadrao.getNome(), lanchePadrao.calcularValor());
            Double valorCalculado = produtoService.calcularValorDoLanchePadrao(lanchePadrao);
            return ResponseEntity.ok(lanchePadraoDTO);
        }
    }