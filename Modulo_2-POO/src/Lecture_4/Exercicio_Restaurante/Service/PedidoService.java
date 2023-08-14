package Lecture_4.Exercicio_Restaurante.Service;

import Lecture_4.Exercicio_Restaurante.Domain.*;
import Lecture_4.Exercicio_Restaurante.Repository.PedidoRepository;

public class PedidoService {

    private PedidoRepository lista;

    public PedidoService() {
        this.lista = new PedidoRepository();
    }

    public Pedido criarPedido(Cliente cliente, Restaurante restaurante, String endereco) {
        Pedido pedido = new Pedido(cliente, restaurante, endereco);
        this.lista.addPedido(pedido);

        return pedido;
    }

    public String addPrato(Pedido pedido, Prato prato) {
        pedido.getPratos().add(prato);

        return "Prato adicionado com Sucesso!";
    }

}
