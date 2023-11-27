package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.model.Transferencia;

import java.math.BigDecimal;

public interface TransferenciaGateway {

    Transferencia buscarPorId(Long id);

    Transferencia criarTransferencia(Transferencia transferencia);

    BigDecimal retornarSaldoRemetente(Transferencia transferencia);
}
