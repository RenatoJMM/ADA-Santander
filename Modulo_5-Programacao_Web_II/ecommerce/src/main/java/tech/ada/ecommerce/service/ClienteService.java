package tech.ada.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.dto.ClienteDTO;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.model.ClienteEndereco;
import tech.ada.ecommerce.model.Endereco;
import tech.ada.ecommerce.repository.ClienteEnderecoRepository;
import tech.ada.ecommerce.repository.ClienteRepository;
import tech.ada.ecommerce.repository.EnderecoRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

//    @Autowired //FAZ A INJEÇÃO DA CLASSE REPOSITORY DENTRO DO SERVICE.
    private ClienteRepository clienteRepo;
    private ClienteEnderecoRepository clienteEnderecoRepository;
    private EnderecoRepository enderecoRepository;

    //MELHOR FAZER DA FORMA ABAIXO: POR QUESTÃO DE SEGURANÇA!!
    //Ou faz o Autowired ou instancia o ClienteRepository no construtor. Como no ex abaixo:
    public ClienteService(ClienteRepository clienteRepo,
                          ClienteEnderecoRepository clienteEnderecoRepository,
                          EnderecoRepository enderecoRepository){
        this.clienteRepo = clienteRepo;
        this.clienteEnderecoRepository = clienteEnderecoRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public List<Cliente> buscarTodosOsClientes(){
        return clienteRepo.findAll();
    }

    public List<Cliente> buscarClientesAtivos(){
        return clienteRepo.findAllAtivos();
    }

//    public Cliente criarCliente(Cliente cliente){
//        Cliente savedCliente = clienteRepo.save(cliente);
//
//        return savedCliente; // ESTA RETORNANDO O CLIENTE PQ AI A GENTE TEM O ID NOVO DELE, PQ O CLIENTE N TEM AINDA O ID DO BD, MAS O SAVEDCLIENTE TEM
//    }

    public ClienteDTO salvarCliente(ClienteDTO clienteDTO){
        try{
            DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNasc = dtf.parse(clienteDTO.getDataNascimento());
            Cliente cliente;
            if(clienteDTO.getId() != null){
                cliente = new Cliente(clienteDTO.getId(),
                        clienteDTO.getNomeCompleto(),
                        dataNasc,
                        clienteDTO.getCpf(),
                        clienteDTO.getEmail(),
                        clienteDTO.getSenha(),
                        clienteDTO.isAtivo());

            }
            else{
                cliente = new Cliente(clienteDTO.getNomeCompleto(),
                        dataNasc,
                        clienteDTO.getCpf(),
                        clienteDTO.getEmail(),
                        clienteDTO.getSenha(),
                        clienteDTO.isAtivo());
            }


            Cliente savedCliente = clienteRepo.save(cliente);

            return criarCLienteDTO(savedCliente);

        } catch(ParseException e){
            return null;
        }

    }

//    public Cliente atualizarCliente(Cliente cliente){
//        Cliente aptCliente = clienteRepo.save(cliente);
//        return aptCliente;
//    }

    public void deletarCliente(Long id){
        clienteRepo.deleteById(id);
    }

    public void ativarDesativarCliente(Boolean ativo, Long id){
        clienteRepo.ativarUsuario(ativo, id);
    }

    public ClienteDTO buscarCliente(Long id){
        Optional<Cliente> optCliente = clienteRepo.findById(id);
        Cliente cliente = optCliente.orElseThrow(() -> new RuntimeException("Não Existe cliente com esse id"));

        return criarCLienteDTO(cliente);
    }

    public List<Cliente> buscaPorNome(String nome){
        List<Cliente> clienteEncontrado = clienteRepo.findByNomeCompletoCustom(nome);
        return clienteEncontrado;
    }

    public void addEndereco(Long id, Long idEnd){
        Optional<Endereco> optEnderececo = enderecoRepository.findById(idEnd);
        Endereco endereco = optEnderececo.orElseThrow(() -> new RuntimeException("Não Existe endereco com esse id"));

        Optional<Cliente> optCliente = clienteRepo.findById(id);
        Cliente cliente = optCliente.orElseThrow(() -> new RuntimeException("Não Existe cliente com esse id"));

        ClienteEndereco clienteEndereco = new ClienteEndereco();
        clienteEndereco.setCliente(cliente);
        clienteEndereco.setEndereco(endereco);

        clienteEnderecoRepository.save(clienteEndereco);
    }

    private ClienteDTO criarCLienteDTO(Cliente cliente){

        DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        String dN = dtf.format(cliente.getDataNascimento());

        return ClienteDTO.builder().nomeCompleto(cliente.getNomeCompleto())
                .email(cliente.getEmail())
                .cpf(cliente.getCpf())
                .dataNascimento(dN)
                .ativo(cliente.isAtivo())
                .senha(cliente.getSenha())
                .id(cliente.getId())
                .build();
    }

}
