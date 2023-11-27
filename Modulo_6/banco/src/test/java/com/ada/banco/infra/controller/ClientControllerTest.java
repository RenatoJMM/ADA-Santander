package com.ada.banco.infra.controller;

import com.ada.banco.domain.model.Client;
import com.ada.banco.infra.gateway.bd.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
public class ClientControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientController clientController;

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    void beforeEach() {
        clientRepository.deleteAll();
    }

    @Test
    public void WhenPassingCorrectlyClientMustCreateAndReturnStatus201() throws Exception{
        //given
        String request = objectMapper.writeValueAsString(new Client(
                "Renato","123456", LocalDate.of(1998,7,25))
        );

        //when
        mockMvc.perform(
                MockMvcRequestBuilders
                    .post("/client")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        //Then
        Client createdClient = clientRepository.findByCpf("123456");

        Assertions.assertEquals("Renato",createdClient.getFullName());

    }

    @Test
    public void WhenPassingWrongInformationToCreateClientMustReturnStatus400() throws Exception{

        //given
        String request = objectMapper.writeValueAsString(new Client()
        );

        //when and then
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/client")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

}
