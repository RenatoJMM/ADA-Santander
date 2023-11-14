package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class ContaGatewayDummyImpl implements ContaGateway {


    @Override
    public Conta buscarPorCPF(String cpf) {
        if(cpf.equals("123456789")){
            return new Conta(12345L,0002L,1L, BigDecimal.ZERO, "Renato","123456789");
        }
        return null;
    }

    @Override
    public Conta salvar(Conta conta) {
        return new Conta(12345L,0002L,1L, BigDecimal.ZERO, "Renato","1234");
    }
}
