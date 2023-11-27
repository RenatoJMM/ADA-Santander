package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.SaqueGateway;
import com.ada.banco.domain.model.*;
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
public class RealizarSaqueTest {

    @Mock
    SaqueGateway saqueGateway;

    @InjectMocks
    RealizarSaque realizarSaque;

    @Test
    public void deveLancarUmaExceptionCasoJaExistaSaqueComMesmoId() {
        Saque saque = new Saque(1L,
                new Account(1L,
                        1L,
                        1L,
                        TipoDeConta.CORRENTE,
                        new Client("Julia","123", LocalDate.of(2005,04,29))),
                BigDecimal.TEN);

        Mockito.when(saqueGateway.findById(saque.getId())).thenReturn(saque);

        Throwable throwable = Assertions.assertThrows(Exception.class, ()-> realizarSaque.execute(saque));

        Assertions.assertEquals("Erro na transação! Saque já realizado!",throwable.getMessage());

    }

    @Test
    public void deveLancarExceptionCasoNaoHajaSaldoSuficienteNaConta() throws Exception {
        Saque saque = new Saque(1L,
                new Account(1L,
                        1L,
                        1L,
                        TipoDeConta.CORRENTE,
                        new Client("Julia","123", LocalDate.of(2005,04,29))),
                BigDecimal.TEN
        );

        Mockito.when(saqueGateway.findById(saque.getId())).thenReturn(null);
        Mockito.when(saqueGateway.checarSeTemSaldo(saque)).thenReturn(false);

        Throwable throwable = Assertions.assertThrows(Exception.class, ()-> realizarSaque.execute(saque));

        Assertions.assertEquals("Saldo insuficiente para saque!",throwable.getMessage());

    }


//    @Test
//    public void deveRealizarDepositoCorretamente() throws Exception {
//        Saque saque = new Saque(1L,
//                new Account(1L,
//                        1L,
//                        1L,
//                        TipoDeConta.CORRENTE,
//                        new Client("Julia","123", LocalDate.of(2005,04,29))),
//                BigDecimal.TEN
//        );
//
//        Mockito.when(depositoGateway.findById(deposito.getId())).thenReturn(null);
//        Mockito.when(depositoGateway.criarDeposito(deposito)).thenReturn(deposito);
//
//        Deposito novoDeposito = realizarDeposito.execute(deposito);
//
//        Assertions.assertAll(
//                ()-> Assertions.assertEquals(1L,novoDeposito.getId()),
//                ()-> Assertions.assertEquals("Julia",novoDeposito.getAccount().getTitular().getFullName()),
//                ()-> Assertions.assertEquals(BigDecimal.TEN,novoDeposito.getValor())
//        );
//    }
}
