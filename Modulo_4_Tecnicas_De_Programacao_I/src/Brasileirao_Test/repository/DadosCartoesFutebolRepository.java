package Brasileirao_Test.repository;

import Brasileirao_Test.model.DadosCartoesFutebol;
import Brasileirao_Test.utils.LeitorCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DadosCartoesFutebolRepository {

    private final List<DadosCartoesFutebol> dadosCartoesFutebolList;

    public DadosCartoesFutebolRepository() {
        this.dadosCartoesFutebolList = new ArrayList<>();
    }

    /**
     * Lê os dados de cartões de futebol de um arquivo CSV e os armazena na lista
     * interna.
     */
    public void lerDadosCartoesFutebol() {
        String caminhoArquivo = "campeonato-brasileiro-cartoes.csv";
        LeitorCSV leitorCSV = new LeitorCSV(caminhoArquivo);

        try {
            List<String[]> records = leitorCSV.lerCSV();

            for (String[] record : records) {
                Integer partidaId = Integer.parseInt(record[0]);
                Integer rodada = Integer.parseInt(record[1]);
                String clube = record[2];
                String cartao = record[3];
                String atleta = record[4];
                Integer numCamisa = record[5].isEmpty() ? null : Integer.parseInt(record[5]);
                String posicao = record[6];
                Integer minuto = Arrays.stream(record[7].split("\\+")).mapToInt(Integer::parseInt).sum();

                DadosCartoesFutebol cartaoObj = new DadosCartoesFutebol(partidaId, rodada, clube, cartao, atleta,
                        numCamisa, posicao, minuto);
                dadosCartoesFutebolList.add(cartaoObj);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime todos os dados de cartões de futebol armazenados na lista.
     */
    public void printarTodosDadosCartoesFutebol() {
        for (DadosCartoesFutebol dadosCartoesFutebol : dadosCartoesFutebolList) {
            System.out.println(dadosCartoesFutebol);
        }
    }

    /**
     * Retorna a lista de dados de cartões de futebol.
     */
    public List<DadosCartoesFutebol> listaDadosCartoesFutebol() {
        return dadosCartoesFutebolList;
    }

}
