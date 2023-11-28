package com.ada.banco.infra.controller;

import com.ada.banco.domain.gateway.ClientGateway;
import com.ada.banco.domain.model.Account;
import com.ada.banco.domain.model.Client;
import com.ada.banco.domain.model.Deposito;
import com.ada.banco.domain.model.Saque;
import com.ada.banco.domain.usecase.CreateNewAccount;
import com.ada.banco.domain.usecase.RealizarDeposito;
import com.ada.banco.domain.usecase.RealizarSaque;
import com.ada.banco.domain.usecase.RealizarTransferencia;
import com.ada.banco.infra.gateway.bd.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private CreateNewAccount createNewAccount;

    private RealizarTransferencia realizarTransferencia;
    private RealizarSaque realizarSaque;
    private RealizarDeposito realizarDeposito;

    private AccountRepository accountRepository;


    public AccountController(CreateNewAccount createNewAccount,
                             RealizarTransferencia realizarTransferencia,
                             RealizarSaque realizarSaque,
                             RealizarDeposito realizarDeposito,
                             AccountRepository accountRepository) {

        this.createNewAccount = createNewAccount;
        this.realizarTransferencia = realizarTransferencia;
        this.realizarSaque = realizarSaque;
        this.realizarDeposito = realizarDeposito;
        this.accountRepository = accountRepository;
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

    // @RequestBody Account account,
    @PostMapping("/deposito")
    public ResponseEntity criarDeposito(@RequestParam("id") Long id,
                                        @RequestParam("valor") Double valor) throws Exception{

        Optional<Account> account = accountRepository.findById(id);

        Deposito deposito = new Deposito(account.orElse(null),BigDecimal.valueOf(valor));

        Deposito newDeposito;

        try{
            newDeposito = realizarDeposito.execute(deposito);
        } catch( Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(newDeposito);

    }

    @PostMapping("/saque")
    public ResponseEntity criarSaque(@RequestParam("id") Long id,
                                        @RequestParam("valor") Double valor) throws Exception{

        Optional<Account> account = accountRepository.findById(id);

        Saque saque = new Saque(account.orElse(null),BigDecimal.valueOf(valor));

        Saque newSaque;

        try{
            newSaque = realizarSaque.execute(saque);
        } catch( Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(newSaque);

    }

}
