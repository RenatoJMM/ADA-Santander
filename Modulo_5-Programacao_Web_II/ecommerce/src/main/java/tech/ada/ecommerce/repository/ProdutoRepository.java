package tech.ada.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Produto;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findBySku(String sku);

    Produto findByPreco(BigDecimal preco);

    @Query("SELECT p FROM Produto p WHERE p.descricao LIKE concat('%', :descricao, '%') ORDER BY p.preco")
    Produto findByDescricaoCustom(@Param("descricao") String descricao);

    @Query(value = "UPDATE produto SET descricao = :descricao WHERE id = :id", nativeQuery = true)
    void atualizarDescricao(@Param("descricao") String descricao, @Param("id") Long id);

    @Query(value = "UPDATE produto SET preco = :preco WHERE id = :id", nativeQuery = true)
    void atualizarPreco(@Param("preco") BigDecimal preco, @Param("id") Long id);

    @Query("SELECT p FROM Produto p WHERE (p.nome ILIKE concat('%', :nome, '%')) AND (p.preco BETWEEN :menorValor AND :maiorValor)")
    List<Produto> buscarProdutoNomePreco(@Param("nome") String nome, @Param("menorValor") BigDecimal menorValor, @Param("maiorValor") BigDecimal maiorValor);

    List<Produto> findByPrecoBetween(BigDecimal preco1, BigDecimal preco2);
    List<Produto> findByPrecoBetween(BigDecimal preco1, BigDecimal preco2, Pageable pageable); // UTILIZANDO O PAGEABLE ELE JÁ ENTENDE QUE VAI PAGINAR


    //SÓ ISSO AQUI JÁ ME RETORNA PAGINADO OS RESULTADOS DA BUSCA
    @Override
    Page<Produto> findAll(Pageable pageable);

    //ORDENAR SEM SER COM PAGINAÇÃO
    @Override
    List<Produto> findAll(Sort sort);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE concat('%', :nome, '%') ORDER BY p.nome")
    List<Produto> findByNomeCompletoCustom(@Param("nome") String nome);
    @Query("UPDATE Produto p SET p.qtdEstoque = :qtd WHERE p.id = :id")
    void atualizarEstoque(@Param("qtd") int qtd, @Param("id") Long id);

}
