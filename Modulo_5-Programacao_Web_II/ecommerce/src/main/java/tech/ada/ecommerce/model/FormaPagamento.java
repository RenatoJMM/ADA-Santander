package tech.ada.ecommerce.model;

import jakarta.persistence.*;

@Entity
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //CRIA OS VALORES AUTOMATICOS PARA MIM
    private Long id;

    @Column(nullable = false)
    private String descricao;
    


}
