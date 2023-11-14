package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.dummy.ContaGatewayDummyImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CriarNovaContaTest {

    @Test
    public void deveLancarUmaExceptionCasoUsuarioJaPossuaUmaConta() {
        //given
        ContaGateway contaGateway = new ContaGatewayDummyImpl(); // Responsavel por verificar se a conta existe
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);


        Conta conta = new Conta(12345L,0002L,1L, BigDecimal.ZERO, "Renato","123456789");

        // when      //then

        Assertions.assertThrows(Exception.class,() -> criarNovaConta.execute(conta));
    }

    @Test
    public void deveCriarUmaContaComSucesso() throws Exception{
        ContaGateway contaGateway = new ContaGatewayDummyImpl(); // Responsavel por verificar se a conta existe
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
        Conta conta = new Conta(12345L,0002L,1L, BigDecimal.ZERO, "Renato","1234");

        Conta novaConta = criarNovaConta.execute(conta);

        Assertions.assertAll(
                ()-> Assertions.assertEquals("Renato", novaConta.getTitular()),
                ()-> Assertions.assertEquals("1234", novaConta.getCpf()));
    }


}
