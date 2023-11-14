package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

public class CriarNovaConta {

    private ContaGateway contaGateway;

    public CriarNovaConta(ContaGateway contaGateway){
        this.contaGateway = contaGateway;
    }

    public Conta execute(Conta conta) throws Exception {
        //validar se o usuário possui uma conta
        if(contaGateway.buscarPorCPF(conta.getCpf()) != null) {
            throw new Exception("Usuario já possui uma conta!");
        }
        // se possuir vamos lançar exception

        Conta novaConta = contaGateway.salvar(conta);
        // se não criar uma nova conta e return true

        return novaConta;
    }
}
