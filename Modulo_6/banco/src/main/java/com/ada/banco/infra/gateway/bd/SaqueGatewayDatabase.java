package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.gateway.SaqueGateway;
import com.ada.banco.domain.model.Saque;

import java.util.Optional;

public class SaqueGatewayDatabase implements SaqueGateway {

    SaqueRepository saqueRepository;

    public SaqueGatewayDatabase(SaqueRepository saqueRepository){
        this.saqueRepository = saqueRepository;
    }

    @Override
    public Saque findById(Long id) {
        Optional<Saque> optionalSaque = saqueRepository.findById(id);
        return optionalSaque.orElse(null);
    }

    @Override
    public Saque criarSaque(Saque saque) {
        return saqueRepository.save(saque);
    }

    @Override
    public Boolean checarSeTemSaldo(Saque saque) {
        return (saque.getAccount().getSaldo().compareTo(saque.getValor()) >= 0);
    }
}
