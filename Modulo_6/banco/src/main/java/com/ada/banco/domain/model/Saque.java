package com.ada.banco.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Saque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Account account;
    @Column
    private BigDecimal valor;

    public Saque() {
    }

    public Saque(Account account, BigDecimal valor) {
        this.account = account;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
