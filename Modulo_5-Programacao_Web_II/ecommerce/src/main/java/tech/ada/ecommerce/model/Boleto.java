package tech.ada.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Boleto extends FormaPagamento{

    @Column(unique = true, nullable = false)
    private String codigoPagamento;

    public Boleto(Long id, String codigoPagamento) {
        super(id);
        this.codigoPagamento = codigoPagamento;
    }

    public Boleto() {
    }

    public String getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(String codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boleto boleto = (Boleto) o;
        return Objects.equals(codigoPagamento, boleto.codigoPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoPagamento);
    }
}
