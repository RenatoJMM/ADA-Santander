package Lecture_4.Exercicio_Restaurante.Service;

import java.util.List;

import Lecture_4.Exercicio_Restaurante.Domain.Cliente;
import Lecture_4.Exercicio_Restaurante.Domain.Pedido;
import Lecture_4.Exercicio_Restaurante.Repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository lista;

    public ClienteService() {
        this.lista = new ClienteRepository();
    }

    public String criarCliente(String nome, String cpf, String endereco) {
        Cliente cliente = new Cliente(nome, cpf, endereco);

        this.lista.addCliente(cliente);

        return "Cliente criado com Sucesso!";
    }

    public void addPedido(Cliente cliente, Pedido pedido) {
        cliente.getPedidos().add(pedido);
    }

    public Cliente buscarCliente(String cpf) {
        List<Cliente> listaClientes = this.lista.getListaClientes();
        if (listaClientes.isEmpty()) {
            return null;
        } else {
            for (Cliente cliente : listaClientes) {
                if (cliente.getCpf().equals(cpf)) {
                    return cliente;
                }
            }
        }
        return null;
    }

    public String listarClientes() {
        return this.lista.toString();
    }

}
