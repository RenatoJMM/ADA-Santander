package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.EmailGateway;
import com.ada.banco.domain.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class) //Inicia os mocks sem a necessidade do BeforeEach
public class CreateNewAccountTest {

    //MVN REPOSITORY -> Mockito core -> Já vem no Spring boot test, então n precisa add a dependencia.

    @Mock
    private AccountGateway contaGateway;

    @Mock
    private EmailGateway emailGateway;

    @InjectMocks
    private CreateNewAccount criarNovaConta;

//      Mockito JUnit Jupiter (já vem com spring)
//    Subistituido pela anotação na classe @ExtendWith(MockitoExtension.class)

//    @BeforeEach
//    private void beforeEach() {
//        MockitoAnnotations.openMocks(this);
//    }



    @Test
    public void deveLancarUmaExceptionCasoUsuarioJaPossuaUmaConta() {
        //given
        //ContaGateway contaGateway = Mockito.mock(ContaGateway.class); // Responsavel por verificar se a conta existe
//        ContaGateway contaGateway = mock(ContaGateway.class); // Responsavel por verificar se a conta existe
//        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);


        Account conta = new Account(0002L,1L, BigDecimal.ZERO, "Renato","123456789");

        // when      //then
        //Mockito.when(contaGateway.buscarPorCPF(conta.getCpf())).thenReturn(conta);
        when(contaGateway.buscarPorCPF(conta.getTitular().getCpf())).thenReturn(conta);

        Assertions.assertThrows(Exception.class,() -> criarNovaConta.execute(conta));

        verify(contaGateway,times(1)).buscarPorCPF(conta.getTitular().getCpf());
        verify(contaGateway,never()).salvar(conta);
    }

    @Test
    public void deveCriarUmaContaComSucesso() throws Exception{

//        ContaGateway contaGateway = Mockito.mock(ContaGateway.class);
//        ContaGateway contaGateway = mock(ContaGateway.class);
//        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);

        Account conta = new Account(2L,1L,"Renato","1234");

        Account novaConta = new Account(1L, 2L,1L,"Renato","1234");

//        Mockito.when(contaGateway.buscarPorCPF(conta.getCpf())).thenReturn(null);
//        Mockito.when(contaGateway.salvar(conta)).thenReturn(conta);
        //Mocks Response
        when(contaGateway.buscarPorCPF(conta.getCpf())).thenReturn(null);
        when(contaGateway.salvar(any())).thenReturn(conta);
        doNothing().when(emailGateway).send(conta.getCpf());

        criarNovaConta.execute(conta);

        Assertions.assertAll(
                ()-> Assertions.assertEquals("Renato", novaConta.getTitular()),
                ()-> Assertions.assertEquals("1234", novaConta.getCpf())
        );

        verify(contaGateway,times(1)).buscarPorCPF(conta.getCpf());
        verify(contaGateway,times(1)).salvar(any());
        verify(emailGateway,times(1)).send(conta.getCpf());

    }


}
