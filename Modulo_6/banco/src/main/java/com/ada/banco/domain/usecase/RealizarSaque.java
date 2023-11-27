package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.gateway.SaqueGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Deposito;
import com.ada.banco.domain.model.Saque;
import org.springframework.stereotype.Component;

@Component
public class RealizarSaque {

    SaqueGateway saqueGateway;

    AccountGateway accountGateway;

    public RealizarSaque(SaqueGateway saqueGateway,AccountGateway accountGateway) {
        this.saqueGateway = saqueGateway;
        this.accountGateway = accountGateway;
    }

    public Saque execute(Saque saque) throws Exception {

        if(!saqueGateway.checarSeTemSaldo(saque)){
            throw new Exception("Saldo insuficiente para saque!");
        }

        Saque novoSaque = saqueGateway.criarSaque(saque);

        Account userAccount = saque.getAccount();

        accountGateway.save(
                new Account(userAccount.getId(),
                        userAccount.getAgencia(),
                        userAccount.getDigito(),
                        userAccount.getTipoDeConta(),
                        userAccount.getSaldo().subtract(saque.getValor()),
                        userAccount.getTitular()));

        return novoSaque;
    }
}
