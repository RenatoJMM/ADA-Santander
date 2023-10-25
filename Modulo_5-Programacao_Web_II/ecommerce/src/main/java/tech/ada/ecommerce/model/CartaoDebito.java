package tech.ada.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
public class CartaoDebito extends FormaPagamento{

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

    public CartaoDebito(Long id, String nomeCompleto, String cpf, int numCartao, LocalDate vencimentoCartao, int cvv) {
        super(id);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.numCartao = numCartao;
        this.vencimentoCartao = vencimentoCartao;
        this.cvv = cvv;
    }

    public CartaoDebito() {
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
}
