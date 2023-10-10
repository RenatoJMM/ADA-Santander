package tech.ada.ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //CRIA OS VALORES AUTOMATICOS PARA MIM
    private Long id;

    @ManyToOne
    private Produto produto;

    private Long qtd;

    @ManyToOne
    private Compra compra;

    private BigDecimal valorTotalProduto;
}
