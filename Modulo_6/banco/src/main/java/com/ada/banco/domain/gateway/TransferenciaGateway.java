package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.model.Transferencia;

import java.math.BigDecimal;

public interface TransferenciaGateway {

    Transferencia buscarPorId(Long id);

    Transferencia criarTransferencia(Transferencia transferencia);
}
