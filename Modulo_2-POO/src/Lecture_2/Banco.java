package Lecture_2;

import java.util.ArrayList;
import java.math.BigDecimal;

public class Banco {

    private static List<Conta> listaDeContas;

    public Banco() {
        listaDeContas = new ArrayList<Conta>();
    }

    public void criarConta(Cliente cliente, String numeroDaConta) {

        Conta novaConta = new Conta(cliente, numeroDaConta);
        listaDeContas.add(novaConta);

    }

    public void criarConta(Conta conta) {
        listaDeContas.add(conta);
    }

    public Conta buscarConta(String numeroConta) {
        for (int i = 0; i < listaDeContas.size(); i++) {
            if (numeroConta.equals(listaDeContas.get(i).numeroConta)) {
                return listaDeContas.get(i);
            }
        }
        return null;
    }

    public String depositar(Conta conta, BigDecimal valor) {
        return conta.depositar(valor);
    }

    public String sacar(Conta conta, BigDecimal valor) {
        return conta.sacar(valor);
    }

    public List<Conta> getListaConta() {
        return listaDeContas;
    }

}
