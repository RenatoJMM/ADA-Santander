package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ClientGateway;
import com.ada.banco.domain.model.Client;
import org.springframework.stereotype.Component;

@Component
public class CreateNewClient {

    private ClientGateway clientGateway;

    CreateNewClient(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(Client client) throws Exception{
        if(clientGateway.findByCpf(client.getCpf()) != null){
            throw new Exception("User already Registered!");
        }

        Client newClient = clientGateway.saveClient(client);

        return newClient;
    }
}
