package Brasileirao_Test.service;

import Brasileirao_Test.model.DadosCartoesFutebol;
import Brasileirao_Test.repository.DadosCartoesFutebolRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JogadorComMaisCartoesVermelhosService {

    private DadosCartoesFutebolRepository dadosCartoesFutebolRepository;

    public JogadorComMaisCartoesVermelhosService(DadosCartoesFutebolRepository dadosCartoesFutebolRepository) {
        this.dadosCartoesFutebolRepository = dadosCartoesFutebolRepository;

    }

    public Map<String, Long> jogadorComMaisCartoesVermelhos() {
        List<DadosCartoesFutebol> dadosCartoesFutebolList = dadosCartoesFutebolRepository.listaDadosCartoesFutebol();

        Map<String, Long> atletaCartoes = dadosCartoesFutebolList.stream()
                .filter(dadosCartoesFutebol -> "Vermelho".equals(dadosCartoesFutebol.getCartao()))
                .collect(Collectors.groupingBy(DadosCartoesFutebol::getAtleta, Collectors.counting()));

        Map.Entry<String, Long> jogadorComMaisCartoesVermelhos = Collections.max(atletaCartoes.entrySet(),
                Map.Entry.comparingByValue());

        return Map.of(jogadorComMaisCartoesVermelhos.getKey(), jogadorComMaisCartoesVermelhos.getValue());
    }
}