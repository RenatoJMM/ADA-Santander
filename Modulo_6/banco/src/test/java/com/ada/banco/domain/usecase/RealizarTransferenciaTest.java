package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.TransferenciaGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.model.Transferencia;
import com.ada.banco.domain.model.enums.TipoDeConta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class RealizarTransferenciaTest {

    @Mock
    TransferenciaGateway transferenciaGateway;

    @InjectMocks
    RealizarTransferencia realizarTransferencia;

    @Test
    public void deveRealizarTransferenciaComSucesso() throws Exception {
        Transferencia transferencia = new Transferencia(1L,
                new Account(1L,
                        1L,
                        1L,
                        TipoDeConta.CORRENTE,
                        new Client("Julia","123", LocalDate.of(2005,04,29))),
                new Account(2L,
                        2L,
                        1L,
                        TipoDeConta.CORRENTE,
                        new Client("Renato","123456", LocalDate.of(1998,7,25))),
                BigDecimal.valueOf(10000.00));

        Mockito.when(transferenciaGateway.buscarPorId(transferencia.getId())).thenReturn(null);
        Mockito.when(transferenciaGateway.checarSeTemSaldo(transferencia)).thenReturn(true);
        Mockito.when(transferenciaGateway.criarTransferencia(transferencia)).thenReturn(transferencia);

        Transferencia novaTransferencia = realizarTransferencia.execute(transferencia);

        Assertions.assertAll(
                () -> Assertions.assertEquals("Julia",novaTransferencia.getRemetente().getTitular().getFullName()),
                () -> Assertions.assertEquals("Renato",novaTransferencia.getDestinatario().getTitular().getFullName()),
                () -> Assertions.assertEquals(BigDecimal.valueOf(10000.00),novaTransferencia.getValor())
        );
    }

    @Test
    public void deveDarErroAoTentarFazerTransferenciaSemSaldo() throws Exception {
        Transferencia transferencia = new Transferencia(1L,
                new Account(1L,
                        1L,
                        1L,
                        TipoDeConta.CORRENTE,
                        new Client("Julia","123", LocalDate.of(2005,04,29))),
                new Account(2L,
                        2L,
                        1L,
                        TipoDeConta.CORRENTE,
                        new Client("Renato","123456", LocalDate.of(1998,7,25))),
                BigDecimal.valueOf(10000.00));

        Mockito.when(transferenciaGateway.buscarPorId(transferencia.getId())).thenReturn(null);
        Mockito.when(transferenciaGateway.checarSeTemSaldo(transferencia)).thenReturn(false);

        Throwable throwable = Assertions.assertThrows(Exception.class, ()-> realizarTransferencia.execute(transferencia));

        Assertions.assertEquals("Saldo do Remetente Insuficiente!",throwable.getMessage());
    }
}
