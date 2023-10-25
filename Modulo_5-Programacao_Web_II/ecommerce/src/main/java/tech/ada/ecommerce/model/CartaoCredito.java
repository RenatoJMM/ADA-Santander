package tech.ada.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
public class CartaoCredito extends FormaPagamento{


    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private int numCartao;

    @Column(nullable = false)
    private LocalDate vencimentoCartao;

    @Column(nullable = false)
    private int cvv;

    @Column
    private int numParcelas;

    public CartaoCredito(Long id, String nomeCompleto, String cpf, int numCartao, LocalDate vencimentoCartao, int cvv, int numParcelas) {
        super(id);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.numCartao = numCartao;
        this.vencimentoCartao = vencimentoCartao;
        this.cvv = cvv;
        this.numParcelas = numParcelas;
    }

    public CartaoCredito() {

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(int numCartao) {
        this.numCartao = numCartao;
    }

    public LocalDate getVencimentoCartao() {
        return vencimentoCartao;
    }

    public void setVencimentoCartao(LocalDate vencimentoCartao) {
        this.vencimentoCartao = vencimentoCartao;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }
}
