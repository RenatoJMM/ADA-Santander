package Lecture_2;

import java.math.BigDecimal;

public class Conta {

    Cliente cliente;
    BigDecimal saldo = new BigDecimal("0");
    String numeroConta;

    public Conta(Cliente cliente, String numeroDaConta) {
        this.cliente = cliente;
        this.numeroConta = numeroDaConta;
    }

    public Conta() {

    }

    public String depositar(BigDecimal valor) {
        saldo = saldo.add(valor);

        return "Novo saldo: R$ " + saldo;
    }

    public String sacar(BigDecimal valor) {
        if (saldo.subtract(valor).doubleValue() < 0) {
            return "Não é possível realizar o saque! Saldo insuficiente";
        } else {
            saldo = saldo.subtract(valor);
            return "Novo saldo: R$ " + saldo;
        }
    }

    @Override
    public boolean equals(Object c) {
        if (c instanceof Conta contaComparar) {
            if (contaComparar.numeroConta.equals(this.numeroConta)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta do cliente: " + this.cliente.nome + ".\nNúmero da Conta:" + this.numeroConta + ".\nSaldo: R$ "
                + saldo;
    }

}
