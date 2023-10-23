package tech.ada.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.ecommerce.model.Cliente;
import tech.ada.ecommerce.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    //    @Autowired
    //    ClienteService clienteService;

    // NÃO PRECISA DE PRIVATE/PUBLIC NA INJEÇÃO DO SERVICE
    // PODE USAR O AUTOWIRED TB, MAS SEMPRE MELHOR INSTANCIAR NA MÃO! COMO É FEITO NESSE CONTROLLER

    ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("")
    public List<Cliente> getClientes(){
        return clienteService.buscarTodosOsClientes();
    }

}
