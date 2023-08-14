package Lecture_4.Exercicio_Restaurante.Repository;

import java.util.ArrayList;
import java.util.List;

import Lecture_4.Exercicio_Restaurante.Domain.Cliente;

public class ClienteRepository {

    private List<Cliente> listaClientes;

    public ClienteRepository() {
        this.listaClientes = new ArrayList<Cliente>();
    }

    public void addCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public String toString() {
        String retorno = "";

        if (listaClientes.isEmpty()) {
            retorno = "Nenhum Cliente criado!";
        } else {
            for (int i = 0; i < listaClientes.size(); i++) {
                retorno += "\n" + (i + 1) + "-" + listaClientes.get(i).toString();
            }
        }

        return retorno;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

}
