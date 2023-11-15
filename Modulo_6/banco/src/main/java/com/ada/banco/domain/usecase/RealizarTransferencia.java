package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.TransferenciaGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transferencia;

import java.math.BigDecimal;

public class RealizarTransferencia {

    TransferenciaGateway transferenciaGateway;

    public RealizarTransferencia(TransferenciaGateway transferenciaGateway) {
        this.transferenciaGateway = transferenciaGateway;
    }

    public Transferencia execute(Transferencia transferencia) throws Exception {

        if(transferenciaGateway.buscarPorId(transferencia.getId()) != null){
            throw new Exception("Erro na transação! Transferência já realizada!");
        }

        Transferencia novaTransferencia = transferenciaGateway.criarTransferencia(transferencia);
        return novaTransferencia;
    }

}
