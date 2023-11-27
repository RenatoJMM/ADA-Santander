package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Deposito;
import com.ada.banco.domain.model.Transferencia;

public class RealizarDeposito {

    DepositoGateway depositoGateway;
    AccountGateway accountGateway;

    public RealizarDeposito(DepositoGateway depositoGateway,AccountGateway accountGateway) {
        this.depositoGateway = depositoGateway;
        this.accountGateway = accountGateway;
    }

    public Deposito execute(Deposito deposito) throws Exception {

        if(depositoGateway.findById(deposito.getId()) != null){
            throw new Exception("Erro na transação! Deposito já realizado!");
        }

        Deposito novoDeposito = depositoGateway.criarDeposito(deposito);

        Account userAccount = deposito.getAccount();

        accountGateway.save(
                new Account(userAccount.getId(),
                        userAccount.getAgencia(),
                        userAccount.getDigito(),
                        userAccount.getTipoDeConta(),
                        userAccount.getSaldo().add(deposito.getValor()),
                        userAccount.getTitular()));

        return novoDeposito;
    }
}
