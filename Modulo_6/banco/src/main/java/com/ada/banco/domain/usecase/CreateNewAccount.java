package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.AccountGateway;
import com.ada.banco.domain.gateway.EmailGateway;
import com.ada.banco.domain.model.Account;
import org.springframework.stereotype.Component;

@Component
public class CreateNewAccount {

    private AccountGateway contaGateway;

    private EmailGateway emailGateway;

    public CreateNewAccount(AccountGateway contaGateway, EmailGateway emailGateway) {
        this.contaGateway = contaGateway;
        this.emailGateway = emailGateway;
    }

    public Account execute(Account conta) throws Exception {
        //validar se o usuário possui uma conta
        if(contaGateway.buscarPorCPF(conta.getCpf()) != null) {
            throw new Exception("Usuario já possui uma conta!");
        }
        // se possuir vamos lançar exception

        Account novaConta = contaGateway.salvar(conta);
        // se não criar uma nova conta e return true

        emailGateway.send(novaConta.getCpf());

        return novaConta;
    }
}
