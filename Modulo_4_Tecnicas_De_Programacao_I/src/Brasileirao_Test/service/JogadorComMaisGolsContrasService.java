package Brasileirao_Test.service;

import Brasileirao_Test.model.DadosGolsFutebol;
import Brasileirao_Test.repository.DadosGolsFutebolRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JogadorComMaisGolsContrasService {

    private DadosGolsFutebolRepository dadosGolsFutebolRepository;

    public JogadorComMaisGolsContrasService(DadosGolsFutebolRepository dadosGolsFutebolRepository) {
        this.dadosGolsFutebolRepository = dadosGolsFutebolRepository;
    }

    public Map<String, Long> jogadorComMaisGolsContras() {
        List<DadosGolsFutebol> dadosGolsFutebolList = dadosGolsFutebolRepository.listaDadosGolsFutebol();

        Map<String, Long> atletasGolsContras = dadosGolsFutebolList.stream()
                .filter(dadosGolsFutebol -> "Gol Contra".equals(dadosGolsFutebol.getTipoDeGol()))
                .collect(Collectors.groupingBy(DadosGolsFutebol::getAtleta, Collectors.counting()));

        Map.Entry<String, Long> jogadorComMaisGolsContra = Collections.max(atletasGolsContras.entrySet(),
                Map.Entry.comparingByValue());

        return Map.of(jogadorComMaisGolsContra.getKey(), jogadorComMaisGolsContra.getValue());
    }

}
