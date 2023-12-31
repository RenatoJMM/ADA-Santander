package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.TransferenciaGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Transferencia;
import org.springframework.stereotype.Component;

@Component
public class RealizarTransferencia {

    TransferenciaGateway transferenciaGateway;

    AccountGateway accountGateway;

    public RealizarTransferencia(TransferenciaGateway transferenciaGateway,AccountGateway accountGateway) {
        this.transferenciaGateway = transferenciaGateway;
        this.accountGateway = accountGateway;
    }

    public Transferencia execute(Transferencia transferencia) throws Exception {

        if(!transferenciaGateway.checarSeTemSaldo(transferencia)){
            throw new Exception("Saldo do Remetente Insuficiente!");
        }

        Transferencia novaTransferencia = transferenciaGateway.criarTransferencia(transferencia);

        Account accountRemetente = transferencia.getRemetente();
        Account accountDestinatario = transferencia.getDestinatario();

        accountGateway.save(
                new Account(accountRemetente.getId(),
                        accountRemetente.getAgencia(),
                        accountRemetente.getDigito(),
                        accountRemetente.getTipoDeConta(),
                        accountRemetente.getSaldo().subtract(transferencia.getValor()),
                        accountRemetente.getTitular()));

        accountGateway.save(
                new Account(accountDestinatario.getId(),
                        accountDestinatario.getAgencia(),
                        accountDestinatario.getDigito(),
                        accountDestinatario.getTipoDeConta(),
                        accountDestinatario.getSaldo().add(transferencia.getValor()),
                        accountDestinatario.getTitular()));

        return novaTransferencia;
    }

}
