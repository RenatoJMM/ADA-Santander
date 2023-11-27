package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.model.Deposito;

import java.util.Optional;

public class DepositoGatewayDatabase implements DepositoGateway {

    DepositoRepository depositoRepository;

    public DepositoGatewayDatabase(DepositoRepository depositoRepository){
        this.depositoRepository = depositoRepository;
    }

    @Override
    public Deposito findById(Long id) {
        Optional<Deposito> optionalDeposito = depositoRepository.findById(id);
        return null;
    }

    @Override
    public Deposito criarDeposito(Deposito deposito) {
        return depositoRepository.save(deposito);
    }
}
