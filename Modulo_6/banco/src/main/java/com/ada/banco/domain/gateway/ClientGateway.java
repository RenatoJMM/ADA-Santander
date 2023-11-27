package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Client;

public interface ClientGateway {

    void buscarPorCPF();

    void cadastrarCLiente(Client cliente);
}
