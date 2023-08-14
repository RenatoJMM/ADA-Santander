package Lecture_4.Exercicio_Restaurante.Service;

import Lecture_4.Exercicio_Restaurante.Domain.Restaurante;
import Lecture_4.Exercicio_Restaurante.Domain.Prato;
import Lecture_4.Exercicio_Restaurante.Domain.Pedido;
import Lecture_4.Exercicio_Restaurante.Repository.RestauranteRepository;

public class RestauranteService {

    private RestauranteRepository lista;

    public RestauranteService() {
        this.lista = new RestauranteRepository();
    }

    public Restaurante criarRestaurante(String nome, String endereco) {
        Restaurante restaurante = new Restaurante(nome, endereco);
        this.lista.addRestaurante(restaurante);

        System.out.println("Restaurante criado com Sucesso!");
        return restaurante;
    }

    public String addPrato(Restaurante restaurante, Prato prato) {
        restaurante.getPratos().add(prato);

        return "Prato adicionado com Sucesso!";
    }

    public void addPedido(Restaurante restaurante, Pedido pedido) {
        restaurante.getPedidos().add(pedido);
    }

    public Restaurante buscarRestaurante(int num) {
        num = num - 1;
        if (this.lista.getListaRestaurantes().isEmpty()) {
            return null;
        } else {
            return this.lista.getListaRestaurantes().get(num);
        }
    }

    public String listarRestaurantes() {
        return this.lista.toString();
    }

    public RestauranteRepository getLista() {
        return lista;
    }

}
