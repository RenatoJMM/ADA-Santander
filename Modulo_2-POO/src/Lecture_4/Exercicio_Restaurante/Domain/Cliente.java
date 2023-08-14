package Lecture_4.Exercicio_Restaurante.Domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private String enderecoPadrao;
    private List<Pedido> pedidos;

    public Cliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.enderecoPadrao = endereco;
        this.pedidos = new ArrayList<Pedido>();
    }

    @Override
    public String toString() {
        String descreverCliente = "Nome do Cliente: " + this.nome + ".\n  CPF: " + this.cpf + ".\n  Endereco Padrao: "
                + this.enderecoPadrao + ".\n  Pedidos Anteriores:";

        if (pedidos.isEmpty()) {
            descreverCliente += "\n   Nenhum pedido Realizado!";
        } else {
            for (int i = 0; i < pedidos.size(); i++) {
                descreverCliente += "\n   " + pedidos.get(i).toString();
            }
        }

        return descreverCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoPadrao() {
        return enderecoPadrao;
    }

    public void setEnderecoPadrao(String enderecoPadrao) {
        this.enderecoPadrao = enderecoPadrao;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
