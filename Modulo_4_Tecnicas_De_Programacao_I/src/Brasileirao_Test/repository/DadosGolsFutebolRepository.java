package Brasileirao_Test.repository;

import Brasileirao_Test.model.DadosGolsFutebol;
import Brasileirao_Test.utils.LeitorCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DadosGolsFutebolRepository {

    private final List<DadosGolsFutebol> dadosGolsFutebolList;

    public DadosGolsFutebolRepository() {
        this.dadosGolsFutebolList = new ArrayList<>();
    }

    /**
     * Lê os dados de gols de futebol de um arquivo CSV e os armazena na lista
     * interna.
     */
    public void lerDadosCartoesFutebolCSV() {
        String caminhoArquivo = "campeonato-brasileiro-gols.csv";
        LeitorCSV leitorCSV = new LeitorCSV(caminhoArquivo);

        try {
            List<String[]> records = leitorCSV.lerCSV();

            for (String[] record : records) {
                Integer partidaId = Integer.parseInt(record[0]);
                Integer rodada = Integer.parseInt(record[1]);
                String clube = record[2];
                String atleta = record[3];
                Integer minuto = Arrays.stream(record[4].split("\\+")).mapToInt(Integer::parseInt).sum();
                String tipoDeGol = null;
                if (record.length >= 6) {
                    tipoDeGol = record[5].isEmpty() ? null : record[5];
                }

                DadosGolsFutebol dadosGolsFutebolObj = new DadosGolsFutebol(partidaId, rodada, clube, atleta, minuto,
                        tipoDeGol);
                dadosGolsFutebolList.add(dadosGolsFutebolObj);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime todos os dados de gols de futebol armazenados na lista.
     */
    public void printarTodosDadosGolsFutebol() {
        for (DadosGolsFutebol dadosGolsFutebol : dadosGolsFutebolList) {
            System.out.println(dadosGolsFutebol);
        }
    }

    /**
     * Retorna a lista de dados de gols de futebol.
     */
    public List<DadosGolsFutebol> listaDadosGolsFutebol() {
        return dadosGolsFutebolList;
    }

}
