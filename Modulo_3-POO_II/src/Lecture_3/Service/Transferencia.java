package Lecture_3.Service;

import java.math.BigDecimal;

import Lecture_3.Model.Conta;
import Lecture_3.Utils.ValidaSenha;

public class Transferencia {

    public static void transfereDinheiro(BigDecimal valor, Conta origem, Conta destino) {
        origem.setSaldo(origem.getSaldo().subtract(valor));
        destino.setSaldo(destino.getSaldo().add(valor));
    }

    public static void transferir(String senha, String metodo, BigDecimal valor, Conta origem, Conta destino) {
        if (ValidaSenha.validar(origem.getSenha(), senha)) {

            if ("PIX".equalsIgnoreCase(metodo)) {
                transfereDinheiro(valor, origem, destino);
                System.out.println("PIX realizado com sucesso!");
            } else if ("TED".equalsIgnoreCase(metodo)) {
                transfereDinheiro(valor, origem, destino);
                System.out.println("TED realizado com sucesso!");
            } else {
                System.out.println("ERRO!");
            }

        } else {
            System.out.println("Senha Inválida! Tente novamente");
        }
    }
}
