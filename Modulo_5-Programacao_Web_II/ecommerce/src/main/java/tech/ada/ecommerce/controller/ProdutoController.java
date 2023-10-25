package tech.ada.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.repository.ProdutoRepository;
import tech.ada.ecommerce.service.ProdutoService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }


    @GetMapping("")
    public ResponseEntity<List<Produto>> getProdutos(){
        try {
            return new ResponseEntity<>(produtoService.buscarTodosOsProdutos(),HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<Produto>> procurarNomePreco(
            @RequestParam("nome") String nome,
            @RequestParam(value = "menorValor", required = false, defaultValue = "0") double menorValor,
            @RequestParam(value = "maiorValor", required = false, defaultValue = "" + Double.MAX_VALUE) double maiorValor){
        try{
            return new ResponseEntity<>(produtoService.buscarProdutoNomePreco(nome,new BigDecimal(menorValor),new BigDecimal(maiorValor)),HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto){
        try {
            return new ResponseEntity<>(produtoService.salvarProduto(produto), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable("id") Long id){
        try {
            produtoService.deletarProduto(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
