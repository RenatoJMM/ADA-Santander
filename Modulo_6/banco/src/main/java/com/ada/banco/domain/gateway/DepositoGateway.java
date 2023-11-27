package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Deposito;

public interface DepositoGateway {

    Deposito findById(Long id);

    Deposito criarDeposito(Deposito deposito);
}
