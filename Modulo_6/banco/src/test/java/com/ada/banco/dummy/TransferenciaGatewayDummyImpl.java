package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.TransferenciaGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transferencia;

import java.math.BigDecimal;

public class TransferenciaGatewayDummyImpl implements TransferenciaGateway {


    @Override
    public Transferencia buscarPorId(Long id) {
        if(id == 1L){
            return new Transferencia(1L,"Julia","Renato",BigDecimal.TEN);
        }
        return null;
    }

    @Override
    public Transferencia criarTransferencia(Transferencia transferencia) {
        return new Transferencia(2L,"Julia","Renato", BigDecimal.valueOf(10000.00));
    }
}
