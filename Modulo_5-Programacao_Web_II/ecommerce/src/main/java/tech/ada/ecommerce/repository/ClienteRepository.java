package tech.ada.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Cliente;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { //TEM QUE SER INTERFACE POIS O JPAREPOSITORY JÁ IMPLEMENTA TUDO QUE PRECISA
    //O PRIMEIRO GENERICS QUER DIZER A CLASSE QUE VAI SER O REPOSITORY, E O SEGUNDO GENERICS É O TIPO DO ID DA CLASSE.
    //ALÉM DO JPAREPOSITORY(TIPO DE REPOSITORE QUE ESTAMOS HERDANDO) TEM O CrudRepository.
    //JPA é o tipo de persistencia

    List<Cliente> findByNomeCompleto(String nome);
    Cliente findClienteByNomeCompleto(String nome);
    Cliente findByNomeCompletoAndCpf(String nome, String cpf);
    Cliente findByDataNascimentoBetween(Date data1, Date data2);

    List<Cliente> findByNomeCompletoLike(String nome);


    // :nome pode ser substituido por ?, mas melhor usar o .nome
    @Query("SELECT c FROM Cliente c WHERE c.nomeCompleto LIKE concat('%', :nome, '%') ORDER BY c.nomeCompleto")
    List<Cliente> findByNomeCompletoCustom(@Param("nome") String nome); //COM ISSO A GENTE ACHA CLIENTE PROCURANDO PRO PARTE DO NOME


    @Query("UPDATE Cliente c SET c.ativo = :ativo WHERE c.id = :id") //ISSO AQUI É JPQL
    void ativarUsuario(@Param("ativo") boolean ativo, @Param("id") Long id);


    @Query(value = "UPDATE cliente SET ativo = :ativo WHERE id = :id", nativeQuery = true) //NATIVEQUERY = TRUE SIGNIFICA Q É SQL
    void ativarUsuario2(@Param("ativo") boolean ativo, @Param("id") Long id);


    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    List<Cliente> findByCustom2(); //IGUALZINHO O findAll que já vem pré modelado
}
