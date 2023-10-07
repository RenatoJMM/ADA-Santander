package Brasileirao_Test.service;

import Brasileirao_Test.model.DadosFullFutebol;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VencedorJogos2008 {
    public static void encontrarTimeComMaisVitoriasNoAno2008EImprimir(List<DadosFullFutebol> partidas) {
        Map<String, Long> contagemVitoriasPorTime = partidas.stream()
                .filter(partida -> partida.getData().getYear() == 2008 && !"-".equals(partida.getVencedor()))
                .collect(Collectors.groupingBy(DadosFullFutebol::getVencedor, Collectors.counting()));

        if (!contagemVitoriasPorTime.isEmpty()) {
            long maxVitorias = contagemVitoriasPorTime.values().stream().max(Long::compare).orElse(0L);

            System.out.println("Times que mais venceram em 2008:");

            contagemVitoriasPorTime.entrySet().stream().filter(entry -> entry.getValue() == maxVitorias)
                    .forEach(entry -> System.out.println(entry.getKey() + " com " + entry.getValue() + " vitórias."));
        } else {
            System.out.println("Nenhum time venceu em 2008.");
        }
    }
}
