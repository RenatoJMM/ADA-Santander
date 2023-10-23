package tech.ada.ecommerce.service;

import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Compra;
import tech.ada.ecommerce.model.ItemProduto;
import tech.ada.ecommerce.repository.CompraRepository;
import tech.ada.ecommerce.repository.ItemProdutoRepository;

import java.util.Optional;

@Service
public class CompraService {

    CompraRepository compraRepository;

    ItemProdutoRepository itemProdutoRepository;

    public CompraService(CompraRepository compraRepository, ItemProdutoRepository itemProdutoRepository){
        this.compraRepository = compraRepository;
        this.itemProdutoRepository = itemProdutoRepository;
    }


    public void salvarCompra(Compra compra, ItemProduto item){
        //ESSE JEITO AQUI FUNCIONA SE o ItemProduto ESTIVESSE @OneToMany(fetch = FetchType.EAGER)
//        ItemProduto item = new ItemProduto();
//        compra.getItens().add(item);


        Compra savedCompra = compraRepository.save(compra);
        item.setCompra(savedCompra);
        itemProdutoRepository.save(item);
    }

    public Compra buscarCompra(Long id){

        //Pode usar desta forma mas como na classe Compra o ItemProduto está @OneToMany(fetch = FetchType.LAZY) não irá carregá-lo
        //Optional<Compra> compra = compraRepository.findById(id);

        //Ou seja usa desta forma:
        Compra compra = compraRepository.buscarCompraPorIdComProdutos(id);

//        return compra.orElseThrow(() -> new RuntimeException("Compra não encontrada!"));
        return compra;
    }
}
