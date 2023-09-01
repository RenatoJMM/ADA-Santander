package Lecture_3;

import java.math.BigDecimal;

import Lecture_3.Model.Conta;
import Lecture_3.Repository.ContaRepository;
import Lecture_3.Service.Transferencia;

public class MainExemplo {

    public static void main(String[] args) {
        String senhaPadrao = "SENHAPADRAO";
        ContaRepository repository = new ContaRepository();
        Conta origem = new Conta();
        Conta destino = new Conta();
        origem.setSaldo(BigDecimal.TEN);
        destino.setSaldo(BigDecimal.TEN);
        repository.create(origem);
        repository.create(destino);
        Transferencia.transferir(senhaPadrao, "TED", BigDecimal.TWO, origem, destino);
        System.out.println("Saldo da conta de origem " + origem.getSaldo());
        System.out.println("Saldo da conta de destino " + destino.getSaldo());
    }

}
