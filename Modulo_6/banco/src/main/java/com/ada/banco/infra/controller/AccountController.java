package com.ada.banco.infra.controller;

import com.ada.banco.domain.gateway.ClientGateway;
import com.ada.banco.domain.usecase.CreateNewAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class AccountController {

    private CreateNewAccount criarNovaConta;

    public AccountController(CreateNewAccount criarNovaConta) {
        this.criarNovaConta = criarNovaConta;
    }

    @PostMapping()
    public ResponseEntity<ClientGateway> save
}
