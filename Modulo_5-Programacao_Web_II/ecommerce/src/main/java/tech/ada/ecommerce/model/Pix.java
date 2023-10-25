package tech.ada.ecommerce.model;

import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pix extends FormaPagamento  {

    private String codigoPagamento;

    public Pix(Long id, String codigoPagamento) {
        super(id);
        this.codigoPagamento = codigoPagamento;
    }

    public Pix() {
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
        Pix pix = (Pix) o;
        return Objects.equals(codigoPagamento, pix.codigoPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoPagamento);
    }
}
