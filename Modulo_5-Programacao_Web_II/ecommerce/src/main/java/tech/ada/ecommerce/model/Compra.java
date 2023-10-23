package tech.ada.ecommerce.model;

import jakarta.persistence.*;
import tech.ada.ecommerce.model.enums.StatusEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Compra  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private Date dataCompra;

    private BigDecimal valorProdutos;

    private BigDecimal valorFrete;

    private BigDecimal desconto;

    private BigDecimal valorTotal;

    @OneToMany(fetch = FetchType.LAZY) //NÃO BAIXAR TODOS OS ITEMSPRODUTOS QUANDO CHAMA AS COMPRAS
    private List<ItemProduto> itens;

    @Enumerated(value = EnumType.STRING) //Precisa colocar o EnumType para pegar o tipo do enum certo, se não pega a ordem do enum
    private StatusEnum status;

//    @OneToOne
//    private FormaPagamento formaPagamento;



    public Compra() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(BigDecimal valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemProduto> getItens() {
        return itens;
    }

    public void setItens(List<ItemProduto> itens) {
        this.itens = itens;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
