package Brasileirao_Test.service;

import Brasileirao_Test.model.DadosFullFutebol;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EstadoMenosJogos {
    public static void encontrarEstadoComMenosJogosNoPeriodoEImprimir(List<DadosFullFutebol> partidas) {
        Map.Entry<String, Long> estadoComMenosJogos = partidas.stream()
                .filter(partida -> partida.getData().getYear() >= 2003 && partida.getData().getYear() <= 2022)
                .collect(Collectors.groupingBy(DadosFullFutebol::getMandanteEstado, Collectors.counting())).entrySet()
                .stream().min(Map.Entry.comparingByValue()).orElse(null);

        if (estadoComMenosJogos != null) {
            System.out.println("O estado com menos jogos no período foi: " + estadoComMenosJogos.getKey() + " com "
                    + estadoComMenosJogos.getValue() + " jogos.");
        } else {
            System.out.println("Nenhum estado teve jogos no período de 2003 a 2022.");
        }
    }
}
