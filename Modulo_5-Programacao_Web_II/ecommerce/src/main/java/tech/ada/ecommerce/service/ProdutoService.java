package tech.ada.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
    this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscarTodosOsProdutos(){
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarProdutosPorPrecos(BigDecimal preco1, BigDecimal preco2){
        List<Produto> listaProdutos = produtoRepository.findByPrecoBetween(preco1, preco2);

        int page = 0;
        int total = 5;

        // VAI ORDENAR POR PRECO NA ORDEM DECRESCENTE
        Pageable pageable = PageRequest.of(page,total, Sort.Direction.DESC, "preco");
        Page<Produto> pageProduto = produtoRepository.findAll(pageable);

        //SEM NENHUMA PROPERTIE VAI ORDENAR POR ID
        Sort sort = Sort.by(Sort.Direction.ASC);
        List<Produto> sortProduto = produtoRepository.findAll(sort);

        return listaProdutos;
    }

    public List<Produto> buscarProdutoNomePreco(String nome,BigDecimal menorValor, BigDecimal maiorValor){
        return produtoRepository.buscarProdutoNomePreco(nome,menorValor,maiorValor);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

}
