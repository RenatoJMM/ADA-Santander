package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Client;

public interface ClientGateway {

    Client findByCpf(String cpf);

    Client saveClient(Client client);
}
