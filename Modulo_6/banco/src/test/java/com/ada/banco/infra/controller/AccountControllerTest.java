package com.ada.banco.infra.controller;

import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.model.enums.TipoDeConta;
import com.ada.banco.infra.gateway.bd.AccountRepository;
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

    @BeforeEach
    void beforeEach() {
        accountRepository.deleteAll();
    }

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
    public void CreateAccountSucessfullyMustReturnStatus201() throws Exception{ //test E2E

        //given
        String request = objectMapper.writeValueAsString(new Account(
                2L,
                1L,
                TipoDeConta.CORRENTE,
                new Client("Renato","123456", LocalDate.of(1998,7,25)))
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
                new Client("Renato","123456", LocalDate.of(1998,7,25))
        );

        //When
        accountController.saveAccount(account);

        //Then
        Account createdAccount = accountRepository.findByAgencia(2L);
        Assertions.assertEquals("Renato",createdAccount.getTitular().getFullName());

    }

}
