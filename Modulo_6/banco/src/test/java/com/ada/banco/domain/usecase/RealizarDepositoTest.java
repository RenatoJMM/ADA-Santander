package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.DepositoGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.model.Deposito;
import com.ada.banco.domain.model.Saque;
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
public class RealizarDepositoTest {

    @Mock
    DepositoGateway depositoGateway;
    @Mock
    AccountGateway accountGateway;

    @InjectMocks
    RealizarDeposito realizarDeposito;

    @Test
    public void deveRealizarDepositoCorretamente() throws Exception {
        Deposito deposito = new Deposito(1L,
                new Account(1L,
                        1L,
                        1L,
                        TipoDeConta.CORRENTE,
                        new Client("Julia","123", LocalDate.of(2005,04,29))),
                BigDecimal.TEN
        );

        Mockito.when(depositoGateway.findById(deposito.getId())).thenReturn(null);
        Mockito.when(depositoGateway.criarDeposito(deposito)).thenReturn(deposito);

        Deposito novoDeposito = realizarDeposito.execute(deposito);

        Assertions.assertAll(
                ()-> Assertions.assertEquals(1L,novoDeposito.getId()),
                ()-> Assertions.assertEquals("Julia",novoDeposito.getAccount().getTitular().getFullName()),
                ()-> Assertions.assertEquals(BigDecimal.TEN,novoDeposito.getValor())
        );
    }

}
