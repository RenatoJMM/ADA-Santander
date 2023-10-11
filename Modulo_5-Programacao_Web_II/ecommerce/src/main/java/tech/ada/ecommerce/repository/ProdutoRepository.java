package tech.ada.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.ada.ecommerce.model.Produto;

import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findByDescricao(String descricao);
    Produto findBySku(String sku);
    Produto findByPreco(BigDecimal preco);
    @Query("SELECT p FROM Produto p WHERE p.descricao LIKE concat('%', :descricao, '%')")
    Produto findByDescricaoCustom(@Param("descricao") String descricao);
    @Query(value = "UPDATE produto SET descricao = :descricao WHERE id = :id", nativeQuery = true)
    void atualizarDescricao(@Param("descricao") String descricao, @Param("id") Long id);
    @Query(value = "UPDATE produto SET preco = :preco WHERE id = :id", nativeQuery = true)
    void atualizarPreco(@Param("preco") BigDecimal preco, @Param("id") Long id);


}
