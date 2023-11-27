package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Saque;
import com.ada.banco.domain.model.Transferencia;

import java.math.BigDecimal;

public interface SaqueGateway {

    Saque findById(Long id);

    Saque criarSaque(Saque saque);

    Boolean checarSeTemSaldo(Saque saque);
}
