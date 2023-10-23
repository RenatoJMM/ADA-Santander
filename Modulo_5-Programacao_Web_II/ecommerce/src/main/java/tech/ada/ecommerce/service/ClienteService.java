package tech.ada.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

//    @Autowired //FAZ A INJEÇÃO DA CLASSE REPOSITORY DENTRO DO SERVICE.
    private ClienteRepository clienteRepo;

    //MELHOR FAZER DA FORMA ABAIXO: POR QUESTÃO DE SEGURANÇA!!
    //Ou faz o Autowired ou instancia o ClienteRepository no construtor. Como no ex abaixo:
    public ClienteService(ClienteRepository clienteRepo){
        this.clienteRepo = clienteRepo;
    }

    public List<Cliente> buscarTodosOsClientes(){
        List<Cliente> clientes = clienteRepo.findAll();
        return clientes;
    }

    public Cliente criarCliente(Cliente cliente){
        Cliente savedCliente = clienteRepo.save(cliente);

        return savedCliente; // ESTA RETORNANDO O CLIENTE PQ AI A GENTE TEM O ID NOVO DELE, PQ O CLIENTE N TEM AINDA O ID DO BD, MAS O SAVEDCLIENTE TEM
    }

    public Cliente atualizarCliente(Cliente cliente){
        Cliente aptCliente = clienteRepo.save(cliente);
        return aptCliente;
    }

    public void ativarCliente(Boolean ativo, Long id){
        clienteRepo.ativarUsuario(ativo, id);
    }

    public Cliente buscarCliente(Long id){
        Optional<Cliente> optCliente = clienteRepo.findById(id);
        return optCliente.orElseThrow(() -> new RuntimeException("Não Existe cliente com esse id"));
    }

    public List<Cliente> buscaPorNome(String nome){
        List<Cliente> clienteEncontrado = clienteRepo.findByNomeCompletoCustom(nome);
        return clienteEncontrado;
    }


}
