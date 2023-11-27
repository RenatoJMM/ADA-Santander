package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Account;

public interface AccountGateway { // Aqui vai ser só a interface

    Account buscarPor (String cpf);
    Account salvar(Account conta);
}

