package Brasileirao_Test.repository;

import Brasileirao_Test.model.DadosEstatisticasFutebol;
import Brasileirao_Test.utils.LeitorCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DadosEstatisticasFutebolRepository {

    private final List<DadosEstatisticasFutebol> dadosEstatisticasFutebolList;

    public DadosEstatisticasFutebolRepository() {
        this.dadosEstatisticasFutebolList = new ArrayList<>();
    }

    /**
     * Lê os dados de estatisticas de futebol de um arquivo CSV e os armazena na
     * lista interna.
     */
    public void lerDadosEstatisticaFutebolCSV() {
        String caminhoArquivo = "campeonato-brasileiro-estatisticas-full.csv";
        LeitorCSV leitorCSV = new LeitorCSV(caminhoArquivo);

        try {
            List<String[]> records = leitorCSV.lerCSV();

            for (String[] record : records) {
                Integer partidaId = Integer.parseInt(record[0]);
                Integer rodada = Integer.parseInt(record[1]);
                String clube = record[2];
                Integer chutes = Integer.parseInt(record[3]);
                Integer chutesNoAlvo = Integer.parseInt(record[4]);
                String posseDeBola = record[5];
                Integer passes = Integer.parseInt(record[6]);
                String precisaoPasses = record[7];
                Integer faltas = Integer.parseInt(record[8]);
                Integer cartaoAmarelo = Integer.parseInt(record[9]);
                Integer cartaoVermelho = Integer.parseInt(record[10]);
                Integer impedimentos = Integer.parseInt(record[11]);
                Integer escanteios = Integer.parseInt(record[12]);

                DadosEstatisticasFutebol dadosEstatisticasFutebol = new DadosEstatisticasFutebol(partidaId, rodada,
                        clube, chutes, chutesNoAlvo, posseDeBola, passes, precisaoPasses, faltas, cartaoAmarelo,
                        cartaoVermelho, impedimentos, escanteios);
                dadosEstatisticasFutebolList.add(dadosEstatisticasFutebol);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime todos os dados de estatisticas de futebol armazenados na lista.
     */
    public void mostrarTodosDadosEstatisticasFutebol() {
        for (DadosEstatisticasFutebol dadosEstatisticasFutebol : dadosEstatisticasFutebolList) {
            System.out.println(dadosEstatisticasFutebol);
        }
    }

    /**
     * Retorna a lista de dados de estatisticas de futebol.
     */
    public List<DadosEstatisticasFutebol> listaDadosEstatisticasFutebol() {
        return dadosEstatisticasFutebolList;
    }

    // public DadosEstatisticasFutebol mostrarDadosEstatisticaFutebol(Integer id,
    // String clube) {
    // for (DadosEstatisticasFutebol dadosEstatisticasFutebol :
    // dadosEstatisticasFutebolList) {
    // if (dadosEstatisticasFutebol.getPartidaId().equals(id) &&
    // dadosEstatisticasFutebol.getClube().equals(clube)) {
    // return dadosEstatisticasFutebol;
    // }
    // }
    // return null;
    // }

}
