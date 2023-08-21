package Lecture_4.Exercicio_Restaurante.Domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private Restaurante restaurante;
    private String endereco;
    private List<Prato> pratos;

    public Pedido(Cliente cliente, Restaurante restaurante, String endereco) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.endereco = endereco;
        this.pratos = new ArrayList<Prato>();
    }

    @Override
    public String toString() {
        String descreverPedido = "Restaurante: " + this.restaurante.getNome() + ".\n   Cliente: "
                + this.cliente.getNome() + ".\n   Entrega no endereço: " + this.endereco + ".\n   Pratos do pedido:";

        if (pratos.isEmpty()) {
            descreverPedido += "\n   Nenhum prato adicionado!";
        } else {
            for (int i = 0; i < pratos.size(); i++) {
                descreverPedido += "\n    " + (i + 1) + "-" + pratos.get(i).toString();
            }
        }

        return descreverPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
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

}
