package tech.ada.ecommerce.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class ItemProduto  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //CRIA OS VALORES AUTOMATICOS PARA MIM
    private Long id;

    @ManyToOne
    private Produto produto;

    private Long qtd;

    @ManyToOne
    private Compra compra;

    private BigDecimal valorTotalProduto;

    public ItemProduto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getQtd() {
        return qtd;
    }

    public void setQtd(Long qtd) {
        this.qtd = qtd;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public BigDecimal getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(BigDecimal valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemProduto that = (ItemProduto) o;
        return Objects.equals(id, that.id) && Objects.equals(produto, that.produto) && Objects.equals(compra, that.compra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto, compra);
    }
}
