package com.ada.banco.domain.model;

import java.math.BigDecimal;

public class Transferencia {

    private Long id;

    private String remetente;

    private String destinatario;

    private BigDecimal valor;

    public Transferencia(Long id, String remetente, String destinatario, BigDecimal valor) {
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
