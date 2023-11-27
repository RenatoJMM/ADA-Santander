package com.ada.banco.infra.gateway.bd;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountGatewayDatabase implements AccountGateway {

    AccountRepository accountRepository;

    public AccountGatewayDatabase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findByAgencia(Long agencia) {
        return accountRepository.findByAgencia(agencia);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
