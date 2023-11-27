package com.ada.banco.infra.controller;

import com.ada.banco.domain.gateway.ClientGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.usecase.CreateNewAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private CreateNewAccount createNewAccount;

    public AccountController(CreateNewAccount createNewAccount) {
        this.createNewAccount = createNewAccount;
    }

    @PostMapping
    public ResponseEntity saveAccount(@RequestBody Account account) throws Exception{
        Account newAccount;

        try{
            newAccount = createNewAccount.execute(account);
        } catch( Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);

    }

}
