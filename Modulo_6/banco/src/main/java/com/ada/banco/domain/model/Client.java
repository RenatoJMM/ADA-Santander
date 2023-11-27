package com.ada.banco.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String fullName;
    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @OneToOne
    private Account conta;

    public Client(String fullName, String cpf, LocalDate dataNascimento) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Account getConta() {
        return conta;
    }

    public void setConta(Account conta) {
        this.conta = conta;
    }
}
