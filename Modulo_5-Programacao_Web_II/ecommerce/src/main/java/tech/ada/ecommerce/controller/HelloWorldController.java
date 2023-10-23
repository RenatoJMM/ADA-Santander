package tech.ada.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.service.ClienteService;
import tech.ada.ecommerce.service.ProdutoService;

import java.math.BigDecimal;
import java.util.List;

@RestController // ISSO É CHAMADO DE ANOTAÇÃO (TUDO QUE COMEA COM @) ISSO É UAM INJEÇÃO DE DEPENDENCIA POIS ESTOU INJETANDO A CLASSE RESTCONTROLLER DENTRO DO HELLOWORLD,
// AI TODOS OS METODOS DO RESTCONTROLLER ESTÃO NO HELLOWORLD
@RequestMapping("/api/v1") // O /api/v1 é o endpoint. Este é o endpoint principal (rota principal)
public class HelloWorldController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProdutoService produtoService;


    @GetMapping("/hello")
    public String hello(){
        System.out.println("Hello World!");
        return "Olá Mundo Lindo";
    }

    @GetMapping("/{nome}")
    public List<Cliente> buscarClientes(@PathVariable("nome") String nome){
        return clienteService.buscaPorNome(nome);
    }

    @GetMapping("/produto/{preco1}/{preco2}")
    public List<Produto> buscarProdutoPorPrecos(@PathVariable("preco1") BigDecimal preco1,
                                                @PathVariable("preco2") BigDecimal preco2){
        return produtoService.buscarProdutosPorPrecos(preco1,preco2);
    }

}
