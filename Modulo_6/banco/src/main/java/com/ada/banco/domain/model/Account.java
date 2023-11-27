package com.ada.banco.domain.model;

import com.ada.banco.domain.model.enums.TipoDeConta;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private Long agencia;

    @Column(nullable = false)
    private Long digito;

    @Enumerated(value = EnumType.STRING)
    private TipoDeConta tipoDeConta;

    @Column
    private BigDecimal saldo;

    @OneToOne(cascade = CascadeType.ALL) // PODE SER MERGE, MAS PRECISA CRIAR CLIENTE ANTES
    private Client titular;


    public Account(Long id, Long agencia, Long digito, TipoDeConta tipoDeConta, Client titular) {
        this.id = id;
        this.agencia = agencia;
        this.digito = digito;
        this.tipoDeConta = tipoDeConta;
        this.saldo = BigDecimal.ZERO;
        this.titular = titular;
    }

    public Account(Long agencia, Long digito, TipoDeConta tipoDeConta, Client titular) {
        this.agencia = agencia;
        this.digito = digito;
        this.tipoDeConta = tipoDeConta;
        this.saldo = BigDecimal.ZERO;
        this.titular = titular;
    }

    public Account(Long id, Long agencia, Long digito, TipoDeConta tipoDeConta, BigDecimal saldo, Client titular) {
        this.id = id;
        this.agencia = agencia;
        this.digito = digito;
        this.tipoDeConta = tipoDeConta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Account() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public Long getDigito() {
        return digito;
    }

    public void setDigito(Long digito) {
        this.digito = digito;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Client getTitular() {
        return titular;
    }

    public void setTitular(Client titular) {
        this.titular = titular;
    }

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(TipoDeConta tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account conta = (Account) o;
        return Objects.equals(id, conta.id) && Objects.equals(agencia, conta.agencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agencia);
    }
}
