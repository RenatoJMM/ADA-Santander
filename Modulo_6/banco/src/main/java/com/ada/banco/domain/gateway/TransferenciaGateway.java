package com.ada.banco.domain.gateway;

import com.ada.banco.domain.model.Transferencia;

public interface TransferenciaGateway {

    Transferencia buscarPorId(Long id);

    Transferencia criarTransferencia(Transferencia transferencia);
}
