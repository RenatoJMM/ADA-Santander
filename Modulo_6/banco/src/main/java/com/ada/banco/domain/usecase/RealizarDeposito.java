package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Deposito;
import com.ada.banco.domain.model.Transferencia;
import org.springframework.stereotype.Component;

@Component
public class RealizarDeposito {

    DepositoGateway depositoGateway;
    AccountGateway accountGateway;

    public RealizarDeposito(DepositoGateway depositoGateway,AccountGateway accountGateway) {
        this.depositoGateway = depositoGateway;
        this.accountGateway = accountGateway;
    }

    public Deposito execute(Deposito deposito) throws Exception {

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
