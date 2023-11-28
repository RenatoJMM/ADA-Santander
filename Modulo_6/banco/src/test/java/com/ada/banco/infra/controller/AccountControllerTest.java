package com.ada.banco.infra.controller;

import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.model.enums.TipoDeConta;
import com.ada.banco.infra.gateway.bd.AccountRepository;
import com.ada.banco.infra.gateway.bd.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountController accountController;



//    @Test
//    public void CreateAccountSucessfullyShouldReturnStatus201() throws Exception{ //test E2E
//
//        //given
//        String request = objectMapper.writeValueAsString(new Account(
//                2L,
//                1L,
//                new Client("Renato","123456", LocalDate.of(1998,7,25)),
//                TipoDeConta.CORRENTE)
//        );
//
//        //when
//        mockMvc.perform(
//                MockMvcRequestBuilders
//                    .post("/account")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(request))
//                .andExpect(MockMvcResultMatchers.status().isCreated());

//        //Then
//        Account createdAccount = accountRepository.findByAgencia(2L);
//
//        Assertions.assertEquals("Renato",createdAccount.getTitular().getFullName());
//
//    }

    @Test
    public void createAccountSucessfullyMustReturnStatus201() throws Exception{

        //given
        String request = objectMapper.writeValueAsString(new Account(
                1L,
                1L,
                TipoDeConta.CORRENTE,
                new Client("Renato","1234567", LocalDate.of(1998,7,25)))
        );

        //when
        mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/account")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void createAccountSucessfully_MustSaveAccount() throws Exception{ //teste de integração
        //Given
        Account account = new Account(
                2L,
                1L,
                TipoDeConta.CORRENTE,
                new Client("Renato","1234568", LocalDate.of(1998,7,25))
        );

        //When
        accountController.saveAccount(account);

        //Then
        Account createdAccount = accountRepository.findByAgencia(2L);
        Assertions.assertEquals("Renato",createdAccount.getTitular().getFullName());

    }

    @Test
    public void whenPassingWrongInformationToCreateAccountMustReturnStatus400() throws Exception{
        //Given
        String request = objectMapper.writeValueAsString(new Account());

        //When and then
        mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/account")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    public void createDepositoCorrectlyAndUpdateAccountSaldo() throws Exception{

        accountController.saveAccount(new Account(
                3L,
                1L,
                TipoDeConta.CORRENTE,
                new Client("Renato","123456", LocalDate.of(1998,7,25))));

        Long idAccount = accountRepository.findByAgencia(3L).getId();

        //when
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/account/deposito?id="+ idAccount +"&valor=10.00"))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        Account userAccount = accountRepository.findByAgencia(3L);

        Assertions.assertTrue(BigDecimal.valueOf(10.00).compareTo(userAccount.getSaldo()) == 0);

    }

    @Test
    public void createSaqueCorrectlyAndUpdateAccountSaldo() throws Exception{

        accountController.saveAccount(new Account(
                4L,
                1L,
                TipoDeConta.CORRENTE,
                new Client("Renato","1234569", LocalDate.of(1998,7,25))));

        Long idAccount = accountRepository.findByAgencia(4L).getId();

        accountController.criarDeposito(idAccount,1000.00);

        //when
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/account/saque?id="+ idAccount +"&valor=100.00"))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        Account userAccount = accountRepository.findByAgencia(4L);
        System.out.println(userAccount.getSaldo());
        System.out.println(userAccount.getId());
        Assertions.assertTrue(BigDecimal.valueOf(900.00).compareTo(userAccount.getSaldo()) == 0);

    }
}
