package Lecture_4.Exercicio_Restaurante.Repository;

import java.util.ArrayList;
import java.util.List;

import Lecture_4.Exercicio_Restaurante.Domain.Pedido;

public class PedidoRepository {

    private List<Pedido> listaPedidos;

    public PedidoRepository() {
        this.listaPedidos = new ArrayList<Pedido>();
    }

    public void addPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    @Override
    public String toString() {
        String retorno = "";

        if (listaPedidos.isEmpty()) {
            retorno = "Nenhum Pedido realizado!";
        } else {
            for (int i = 0; i < listaPedidos.size(); i++) {
                retorno += "\n" + listaPedidos.get(i).toString();
            }
        }

        return retorno;
    }
}
