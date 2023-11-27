package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.EmailGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.model.enums.TipoDeConta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class) //Inicia os mocks sem a necessidade do BeforeEach
public class CreateNewAccountTest {

    //MVN REPOSITORY -> Mockito core -> Já vem no Spring boot test, então n precisa add a dependencia.

    @Mock
    private AccountGateway accountGateway;

    @Mock
    private EmailGateway emailGateway;

    @InjectMocks
    private CreateNewAccount createNewAccount;

//      Mockito JUnit Jupiter (já vem com spring)
//    Subistituido pela anotação na classe @ExtendWith(MockitoExtension.class)

//    @BeforeEach
//    private void beforeEach() {
//        MockitoAnnotations.openMocks(this);
//    }

//    @Test
//    public void deveLancarUmaExceptionCasoUsuarioJaPossuaUmaConta() {
//        //given
//        //ContaGateway contaGateway = Mockito.mock(ContaGateway.class); // Responsavel por verificar se a conta existe
////        ContaGateway contaGateway = mock(ContaGateway.class); // Responsavel por verificar se a conta existe
////        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
//
//
//        Account conta = new Account(0002L,1L, BigDecimal.ZERO, "Renato","123456789");
//
//        // when      //then
//        //Mockito.when(contaGateway.buscarPorCPF(conta.getCpf())).thenReturn(conta);
//        when(accountGateway.buscarPorCPF(conta.getTitular().getCpf())).thenReturn(conta);
//
//        Assertions.assertThrows(Exception.class,() -> criarNovaConta.execute(conta));
//
//        verify(accountGateway,times(1)).buscarPorCPF(conta.getTitular().getCpf());
//        verify(accountGateway,never()).save(conta);
//    }

    @Test
    public void deveLancarUmaExceptionCasoUsuarioJaPossuaUmaConta() {
        Account account = new Account(
                2L,
                1L,
                TipoDeConta.CORRENTE,
                new Client("Renato","123456", LocalDate.of(1998,7,25)));

        when(accountGateway.findByAgencia(account.getAgencia())).thenReturn(account);

        Assertions.assertThrows(Exception.class, () -> createNewAccount.execute(account));

        verify(accountGateway,times(1)).findByAgencia(account.getAgencia());
        verify(accountGateway,times(0)).save(account);

    }

    @Test
    public void deveCriarUmaContaComSucesso() throws Exception {
        Account account = new Account(
                2L,
                1L,
                TipoDeConta.CORRENTE,
                new Client("Renato","123456", LocalDate.of(1998,7,25)));

        when(accountGateway.findByAgencia(account.getAgencia())).thenReturn(null);
        when(accountGateway.save(any())).thenReturn(account);
        doNothing().when(emailGateway).send(account.getTitular().getCpf());

        createNewAccount.execute(account);

        Assertions.assertAll(
                () -> Assertions.assertEquals(2L,account.getAgencia()),
                () -> Assertions.assertEquals(LocalDate.of(1998,7,25),account.getTitular().getDataNascimento())
        );

    }

//    @Test
//    public void deveCriarUmaContaComSucesso() throws Exception{
//
////        ContaGateway contaGateway = Mockito.mock(ContaGateway.class);
////        ContaGateway contaGateway = mock(ContaGateway.class);
////        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
//
//        Account conta = new Account(2L,1L,"Renato","1234");
//
//        Account novaConta = new Account(1L, 2L,1L,"Renato","1234");
//
////        Mockito.when(contaGateway.buscarPorCPF(conta.getCpf())).thenReturn(null);
////        Mockito.when(contaGateway.salvar(conta)).thenReturn(conta);
//        //Mocks Response
//        when(accountGateway.buscarPorCPF(conta.getCpf())).thenReturn(null);
//        when(accountGateway.save(any())).thenReturn(conta);
//        doNothing().when(emailGateway).send(conta.getCpf());
//
//        createNewAccount.execute(conta);
//
//        Assertions.assertAll(
//                ()-> Assertions.assertEquals("Renato", novaConta.getTitular()),
//                ()-> Assertions.assertEquals("1234", novaConta.getCpf())
//        );
//
//        verify(accountGateway,times(1)).buscarPorCPF(conta.getCpf());
//        verify(accountGateway,times(1)).save(any());
//        verify(emailGateway,times(1)).send(conta.getCpf());
//
//    }


}
