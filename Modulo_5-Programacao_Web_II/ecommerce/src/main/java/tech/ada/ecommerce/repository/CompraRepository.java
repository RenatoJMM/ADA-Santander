package tech.ada.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Compra;
import tech.ada.ecommerce.model.enums.StatusEnum;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {

    @Query("UPDATE Compra c SET c.status = :status WHERE c.id = :id")
    void atualizarStatus(@Param("status")StatusEnum status, @Param("id") Long id);

    //Criado esse metodo pois no findById normal não vai mostrar os itemProduto, pois está como @OneToMany(fetch = FetchType.LAZY) na classe compra
    @Query("SELECT c FROM Compra c INNER JOIN c.itens WHERE c.id = :id")
    Compra buscarCompraPorIdComProdutos(@Param("id") Long id);
}
