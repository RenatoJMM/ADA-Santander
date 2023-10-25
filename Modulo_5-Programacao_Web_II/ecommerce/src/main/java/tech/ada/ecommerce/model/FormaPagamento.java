package tech.ada.ecommerce.model;

import jakarta.persistence.*;

import java.io.Serializable;

//@MappedSuperclass //UTILIZADO PARA N CRIAR ESSA TABELA EM SI, SÓ AS FILHAS
//@Inheritance(strategy = InheritanceType.JOINED) //TABLE_PER_CLASS ( Não funciona @GeneratedValue(strategy = GenerationType.IDENTITY)) OU SINGLE_TABLE
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class FormaPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    private Compra compra;

    public FormaPagamento(Long id) {
        this.id = id;
    }

    public FormaPagamento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
