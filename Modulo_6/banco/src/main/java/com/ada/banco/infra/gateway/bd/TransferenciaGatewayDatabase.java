package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.gateway.TransferenciaGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Transferencia;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class TransferenciaGatewayDatabase implements TransferenciaGateway {

    TransferenciaRepository transferenciaRepository;

    public TransferenciaGatewayDatabase(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @Override
    public Transferencia buscarPorId(Long id) {
        Optional<Transferencia> optTransf = transferenciaRepository.findById(id);
        return optTransf.orElse(null);
    }

    @Override
    public Transferencia criarTransferencia(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }

    @Override
    public BigDecimal retornarSaldoRemetente(Transferencia transferencia) {
        return transferencia.getRemetente().getSaldo();
    }
}
