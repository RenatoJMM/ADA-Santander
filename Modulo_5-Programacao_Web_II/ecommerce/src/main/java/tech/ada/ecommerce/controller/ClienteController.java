package tech.ada.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.ecommerce.dto.ClienteDTO;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.service.ClienteService;

import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    //    @Autowired
    //    ClienteService clienteService;

    // NÃO PRECISA DE PRIVATE/PUBLIC NA INJEÇÃO DO SERVICE
    // PODE USAR O AUTOWIRED TB, MAS SEMPRE MELHOR INSTANCIAR NA MÃO! COMO É FEITO NESSE CONTROLLER

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }


//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping("")
    public List<Cliente> getClientes(){
        return clienteService.buscarTodosOsClientes();
    }

    @GetMapping("/ativos")
    public List<Cliente> getClientesAtivos(){
        return clienteService.buscarClientesAtivos();
    }


    //NO RETORNO DO METODO PODERIA SER ResponseEntity<Cliente>, OU A ANOTAÇÃO @ResponseStatus(HttpStatus.CREATED) QUE JÁ RETORNA UMA MSG DE SUCESSO
    //@ResponseStatus(HttpStatus.CREATED) Desta forma aqui só conseguimos enviar resposta de sucesso
    //@PostMapping("")
    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT}) //COm isso ele cosnegue tanto att quando criar um novo cliente
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO cliente){
        try{
            ClienteDTO savedCliente = clienteService.salvarCliente(cliente);
            if(savedCliente != null){
                return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
            } else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable("id") Long idCliente){

        try{
            ClienteDTO cliente = clienteService.buscarCliente(idCliente);
            if(cliente != null){
                return new ResponseEntity<>(cliente, HttpStatus.FOUND);
            } else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // JÁ QUE USAMOS RequestParam temos que usar http://localhost:8080/api/v1/cliente/nome?nome=Rena
    @GetMapping("/nome")
    public ResponseEntity<List<Cliente>> getClienteByNome(@RequestParam("nome") String nome){
        return new ResponseEntity<>(clienteService.buscaPorNome(nome), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id){
        clienteService.deletarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> ativarDesativarCliente(@PathVariable("id") Long id, @RequestParam("ativo") Boolean ativo){
        clienteService.ativarDesativarCliente(ativo,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("")
//    public ResponseEntity<ClienteDTO> atualizarCliente(@RequestBody ClienteDTO cliente){
//        try{
//            ClienteDTO savedCliente = clienteService.salvarCliente(cliente);
//            if(savedCliente != null){
//                return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
//            } else{
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
