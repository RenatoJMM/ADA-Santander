package tech.ada.ecommerce.model;

import jakarta.persistence.*;

//@MappedSuperclass //UTILIZADO PARA N CRIAR ESSA TABELA EM SI, SÓ AS FILHAS
//@Inheritance(strategy = InheritanceType.JOINED) //TABLE_PER_CLASS OU SINGLE_TABLE
@Inheritance(strategy = InheritanceType.JOINED)
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;

//    @OneToOne
//    private Compra compra;

    public FormaPagamento(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public FormaPagamento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
