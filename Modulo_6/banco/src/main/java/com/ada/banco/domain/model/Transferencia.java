package com.ada.banco.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Account remetente;
    @OneToOne
    private Account destinatario;
    @Column
    private BigDecimal valor;

    public Transferencia(Long id, Account remetente, Account destinatario, BigDecimal valor) {
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
    }

    public Transferencia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getRemetente() {
        return remetente;
    }

    public void setRemetente(Account remetente) {
        this.remetente = remetente;
    }

    public Account getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Account destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
