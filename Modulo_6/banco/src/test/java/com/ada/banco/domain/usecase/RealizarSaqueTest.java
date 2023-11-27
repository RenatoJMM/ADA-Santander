package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.SaqueGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.model.Saque;
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
public class RealizarSaqueTest {

    @Mock
    SaqueGateway saqueGateway;

    @InjectMocks
    RealizarSaque realizarSaque;

//    @Test
//    public void deveLancarUmaExceptionCasoJaExistaSaqueComMesmoId() {
//        Saque saque = new Saque(1L,
//                new Account(1L,
//                        1L,
//                        new Client("Julia","123", LocalDate.of(2005,04,29)),
//                        TipoDeConta.CORRENTE),
//                BigDecimal.TEN);
//
//        Mockito.when(transferenciaGateway.buscarPorId(transferencia.getId())).thenReturn(transferencia);
//
//        Throwable throwable = Assertions.assertThrows(Exception.class, ()-> realizarTransferencia.execute(transferencia));
//
//        Assertions.assertEquals("Erro na transação! Transferência já realizada!",throwable.getMessage());
//
//    }
}
