package Brasileirao_Test.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Brasileirao_Test.model.DadosFullFutebol;
import Brasileirao_Test.repository.DadosCartoesFutebolRepository;
import Brasileirao_Test.repository.DadosEstatisticasFutebolRepository;
import Brasileirao_Test.repository.DadosFullFutebolRepository;
import Brasileirao_Test.repository.DadosGolsFutebolRepository;
import Brasileirao_Test.service.EstadoMenosJogos;
import Brasileirao_Test.service.JogadorComMaisCartoesAmarelosService;
import Brasileirao_Test.service.JogadorComMaisCartoesVermelhosService;
import Brasileirao_Test.service.JogadorComMaisGolsContrasService;
import Brasileirao_Test.service.JogadorComMaisGolsPenaltisService;
import Brasileirao_Test.service.JogadorComMaisGolsService;
import Brasileirao_Test.service.PartidaComMaisGolsService;
import Brasileirao_Test.service.VencedorJogos2008;

public class Main {

    public static void main(String[] args) {

        DadosEstatisticasFutebolRepository dadosEstatisticasFutebolRepository = new DadosEstatisticasFutebolRepository();
        DadosCartoesFutebolRepository dadosCartoesFutebolRepository = new DadosCartoesFutebolRepository();
        DadosFullFutebolRepository dadosFullFutebolRepository = new DadosFullFutebolRepository();
        DadosGolsFutebolRepository dadosGolsFutebolRepository = new DadosGolsFutebolRepository();

        // Inicia a leitura e conversão dos CSVs
        dadosEstatisticasFutebolRepository.lerDadosEstatisticaFutebolCSV();
        dadosCartoesFutebolRepository.lerDadosCartoesFutebol();
        dadosFullFutebolRepository.lerDadosFullFutebolCSV();
        dadosGolsFutebolRepository.lerDadosCartoesFutebolCSV();

        // Instanciando Classes Service

        JogadorComMaisGolsPenaltisService jogadorComMaisGolsPenaltis = new JogadorComMaisGolsPenaltisService(
                dadosGolsFutebolRepository);
        JogadorComMaisGolsService jogadorComMaisGols = new JogadorComMaisGolsService(dadosGolsFutebolRepository);
        JogadorComMaisGolsContrasService jogadorComMaisGolsContrasService = new JogadorComMaisGolsContrasService(
                dadosGolsFutebolRepository);
        JogadorComMaisCartoesAmarelosService jogadorComMaisCartoesAmarelosService = new JogadorComMaisCartoesAmarelosService(
                dadosCartoesFutebolRepository);
        JogadorComMaisCartoesVermelhosService jogadorComMaisCartoesVermelhosService = new JogadorComMaisCartoesVermelhosService(
                dadosCartoesFutebolRepository);
        PartidaComMaisGolsService partidaComMaisGolsService = new PartidaComMaisGolsService(dadosFullFutebolRepository);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            // Menu interativo
            System.out.println("----------------- Menu -----------------\n");
            System.out.println("1- Ver amostra tabela Campeonato Brasileiro Cartões.");
            System.out.println("2- Ver amostra tabela Campeonato Brasileiro Estatísticas Full.");
            System.out.println("3- Ver amostra tabela Campeonato Brasileiro Full.");
            System.out.println("4- Ver amostra tabela Campeonato Brasileiro Gols.");
            System.out.println("5- Ver Curiosidades sobre o Campeonato Brasileiro de 2003 a 2022.");
            System.out.println("6- Sair.");

            System.out.println("Opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    imprimirTabela(dadosCartoesFutebolRepository.listaDadosCartoesFutebol());
                    break;
                case 2:
                    imprimirTabela(dadosEstatisticasFutebolRepository.listaDadosEstatisticasFutebol());
                    break;
                case 3:
                    imprimirTabela(dadosFullFutebolRepository.listaDadosFullFutebol());
                    break;
                case 4:
                    imprimirTabela(dadosGolsFutebolRepository.listaDadosGolsFutebol());
                    break;
                case 5:
                    System.out.println("----------------- Curiosidades -----------------\n");

                    System.out.print("1- ");
                    VencedorJogos2008.encontrarTimeComMaisVitoriasNoAno2008EImprimir(
                            dadosFullFutebolRepository.listaDadosFullFutebol());

                    System.out.print("\n2- ");
                    EstadoMenosJogos.encontrarEstadoComMenosJogosNoPeriodoEImprimir(
                            dadosFullFutebolRepository.listaDadosFullFutebol());

                    Map<String, Long> resultMaisGols = jogadorComMaisGols.execute();
                    System.out.println("\n3- Jogador com mais gols: " + getKey(resultMaisGols) + ", com um total de "
                            + getValue(resultMaisGols) + " gols.");

                    Map<String, Long> resultMaisGolsPenaltis = jogadorComMaisGolsPenaltis.execute();
                    System.out.println("\n4- Jogador com mais gols de penalti: " + getKey(resultMaisGolsPenaltis)
                            + ", com um total de " + getValue(resultMaisGolsPenaltis) + " gols.");

                    Map<String, Long> resultMaisGolsContra = jogadorComMaisGolsContrasService
                            .jogadorComMaisGolsContras();
                    System.out.println("\n5- Jogador com mais gols contra: " + getKey(resultMaisGolsContra)
                            + ", com um total de " + getValue(resultMaisGolsContra) + " gols.");

                    Map<String, Long> resultMaisCartoesAmarelos = jogadorComMaisCartoesAmarelosService
                            .jogadorComMaisCartoesAmarelos();
                    System.out.println("\n6- Jogador que mais recebeu cartões amarelos: "
                            + getKey(resultMaisCartoesAmarelos) + ", com um total de "
                            + getValue(resultMaisCartoesAmarelos) + " cartões amarelos.");

                    Map<String, Long> resultMaisCartoesVermelhos = jogadorComMaisCartoesVermelhosService
                            .jogadorComMaisCartoesVermelhos();
                    System.out.println("\n7- Jogador com mais cartões vermelhos: " + getKey(resultMaisCartoesVermelhos)
                            + ", com um total de " + getValue(resultMaisCartoesVermelhos) + " cartões vermelhos.");

                    DadosFullFutebol partidaComMaisGols = partidaComMaisGolsService.partidaComMaisGols();
                    System.out.println("\n8- Placar da partida com mais gols: " + partidaComMaisGols.getMandante() + " "
                            + partidaComMaisGols.getMandantePlacar() + " x " + partidaComMaisGols.getVisitantePlacar()
                            + " " + partidaComMaisGols.getVisitante());
                    break;
            }
        }
    }

    public static String getKey(Map<String, Long> mapa) {

        for (Map.Entry<String, Long> pair : mapa.entrySet()) {
            return pair.getKey();
        }

        return null;
    }

    public static Long getValue(Map<String, Long> mapa) {

        for (Map.Entry<String, Long> pair : mapa.entrySet()) {
            return pair.getValue();
        }

        return null;
    }

    public static void imprimirTabela(List<?> table) {
        for (Object object : table) {
            System.out.println(object.toString());
        }
    }

}
