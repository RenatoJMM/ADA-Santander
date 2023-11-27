package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.EmailGateway;
import com.ada.banco.domain.model.Account;
import org.springframework.stereotype.Component;

@Component
public class CreateNewAccount {

    private AccountGateway accountGateway;

    private EmailGateway emailGateway;

    CreateNewAccount(AccountGateway accountGateway, EmailGateway emailGateway) {
        this.accountGateway = accountGateway;
        this.emailGateway = emailGateway;
    }

    public Account execute(Account account) throws Exception {

        if(accountGateway.findByAgencia(account.getAgencia()) != null) {
            throw new Exception("Account already Registered!");
        }

        Account newAccount = accountGateway.save(account);
        emailGateway.send(newAccount.getTitular().getCpf());

        return newAccount;
    }
}
