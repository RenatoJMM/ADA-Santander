package Brasileirao_Test.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Brasileirao_Test.model.DadosGolsFutebol;
import Brasileirao_Test.repository.DadosGolsFutebolRepository;

public class JogadorComMaisGolsPenaltis {

    private static DadosGolsFutebolRepository dadosGolsFutebolRepository;

    public JogadorComMaisGolsPenaltis(DadosGolsFutebolRepository dadosGols) {
        dadosGolsFutebolRepository = dadosGols;
    }

    public String jogadorComMaisGols() {
        List<DadosGolsFutebol> dados = dadosGolsFutebolRepository.listaDadosGolsFutebol();

        // Map<String,Double> jogadorMaisGols = dados.stream().filter( gol ->
        // gol.getTipoDeGol().equals(null) &&
        // gol.getTipoDeGol().equals("Penalty")).collect(Collectors.toMap(keyMapper,
        // valueMapper))

        return null;
    }
}
