package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Conta;

public interface ContaGateway { // Aqui vai ser só a interface

    Conta buscarPorCPF (String cpf);
    Conta salvar(Conta conta);
}
