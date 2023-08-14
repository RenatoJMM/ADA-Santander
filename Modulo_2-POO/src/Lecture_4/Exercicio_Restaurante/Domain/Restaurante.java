package Lecture_4.Exercicio_Restaurante.Domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {

    private String nome;
    private String endereco;
    private List<Prato> pratos;
    private List<Pedido> pedidos;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.pratos = new ArrayList<Prato>();
        this.pedidos = new ArrayList<Pedido>();
    }

    public boolean equals(Object o) {
        if (o instanceof Restaurante rest) {
            if (rest.nome.equals(this.nome)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String retorno = "Restaurante: " + this.nome + ".\n  Endereço: " + this.endereco + ".\n  Cardápio: ";

        if (pratos.isEmpty()) {
            retorno += "\n  Nenhum prato adicionado!";
        } else {
            for (int i = 0; i < pratos.size(); i++) {
                retorno += "\n   " + (i + 1) + "-" + pratos.get(i).toString();
            }
        }
        return retorno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

}
