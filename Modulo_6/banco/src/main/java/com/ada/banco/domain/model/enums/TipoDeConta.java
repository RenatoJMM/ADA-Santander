package com.ada.banco.domain.model.enums;

public enum TipoDeConta {

    CORRENTE("Conta Corrente"),
    POUPANCA("Poupança");

    private String tipoConta;

    TipoDeConta(String tipoConta){
        this.tipoConta = tipoConta;
    }

    public String getTipoConta(){
        return this.tipoConta;
    }

}
