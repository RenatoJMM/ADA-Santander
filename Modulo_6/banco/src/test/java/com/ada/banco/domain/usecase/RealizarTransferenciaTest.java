package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.TransferenciaGateway;
import com.ada.banco.domain.model.Transferencia;
import com.ada.banco.dummy.TransferenciaGatewayDummyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class RealizarTransferenciaTest {

    @Test
    public void deveLancarUmaExceptionCasoJaExistaTransferenciaComMesmoId() throws Exception {
        TransferenciaGateway transferenciaGateway = new TransferenciaGatewayDummyImpl();

        RealizarTransferencia realizarTransferencia = new RealizarTransferencia(transferenciaGateway);

        Transferencia transferencia = new Transferencia(1L,"Julia","Renato", BigDecimal.TEN);

        Throwable throwable = Assertions.assertThrows(Exception.class, ()-> realizarTransferencia.execute(transferencia));

        Assertions.assertEquals("Erro na transação! Transferência já realizada!",throwable.getMessage());

    }

    @Test
    public void deveRealizarTransferenciaComSucesso() throws Exception {
        TransferenciaGateway transferenciaGateway = new TransferenciaGatewayDummyImpl();

        RealizarTransferencia realizarTransferencia = new RealizarTransferencia(transferenciaGateway);

        Transferencia transferencia = new Transferencia(2L,"Julia","Renato", BigDecimal.valueOf(10000.00));

        Transferencia novaTransferencia = realizarTransferencia.execute(transferencia);

        Assertions.assertAll(
                () -> Assertions.assertEquals("Julia",novaTransferencia.getRemetente()),
                () -> Assertions.assertEquals("Renato",novaTransferencia.getDestinatario()),
                () -> Assertions.assertEquals(BigDecimal.valueOf(10000.00),novaTransferencia.getValor())
        );
    }
}
