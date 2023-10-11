package tech.ada.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    public List<Cliente> buscarTodosOsClientes(){
        List<Cliente> clientes = clienteRepo.findAll();
        return clientes;
    }

    public Cliente criarCliente(Cliente cliente){
        Cliente savedCliente = clienteRepo.save(cliente);

        return savedCliente; // ESTA RETORNANDO O CLIENTE PQ AI A GENTE TEM O ID NOVO DELE, PQ O CLIENTE N TEM AINDA O ID DO BD, MAS O SABEDCLIENTE TEM
    }

//    public Cliente atualizarCliente(Cliente cliente){
//
//    }

    public Cliente buscarCliente(Long id){
        Optional<Cliente> optCliente = clienteRepo.findById(id);
        return optCliente.orElseThrow(() -> new RuntimeException("Não Existe cliente com esse id"));
    }

    public List<Cliente> buscaPorNome(String nome){
        List<Cliente> clienteEncontrado = clienteRepo.findByNomeCompleto(nome);
        return clienteEncontrado;
    }


}
