package Brasileirao_Test.repository;

import Brasileirao_Test.model.DadosFullFutebol;
import Brasileirao_Test.utils.LeitorCSV;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DadosFullFutebolRepository {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    private final List<DadosFullFutebol> dadosFullFutebolList;

    public DadosFullFutebolRepository() {
        this.dadosFullFutebolList = new ArrayList<>();
    }

    /**
     * Lê os dados de fullCSV de futebol de um arquivo CSV e os armazena na lista
     * interna.
     */
    public void lerDadosFullFutebolCSV() {
        String caminhoArquivo = "campeonato-brasileiro-full.csv";
        LeitorCSV leitorCSV = new LeitorCSV(caminhoArquivo);

        try {
            List<String[]> records = leitorCSV.lerCSV();

            for (String[] record : records) {
                Integer id = Integer.parseInt(record[0]);
                Integer rodada = Integer.parseInt(record[1]);
                LocalDate data = LocalDate.parse(record[2], dateFormatter);
                LocalTime hora = LocalTime.parse(record[3], timeFormatter);
                String mandante = record[4];
                String visitante = record[5];
                String formacaoMandante = record[6];
                String formacaoVisitante = record[7];
                String tecnicoMandante = record[8];
                String tecnicoVisitante = record[9];
                String vencedor = record[10];
                String arena = record[11];
                Integer mandantePlacar = Integer.parseInt(record[12]);
                Integer visitantePlacar = Integer.parseInt(record[13]);
                String mandanteEstado = record[14];
                String visitanteEstado = record[15];

                DadosFullFutebol dadosFullFutebolObj = new DadosFullFutebol(id, rodada, data, hora, mandante, visitante,
                        formacaoMandante, formacaoVisitante, tecnicoMandante, tecnicoVisitante, vencedor, arena,
                        mandantePlacar, visitantePlacar, mandanteEstado, visitanteEstado);
                dadosFullFutebolList.add(dadosFullFutebolObj);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime todos os dados de fullCSV de futebol armazenados na lista.
     */
    public void mostrarTodosDadosFullFutebol() {
        for (DadosFullFutebol dadosFullFutebol : dadosFullFutebolList) {
            System.out.println(dadosFullFutebol);
        }
    }

    /**
     * Retorna a lista de dados de fullCSV de futebol.
     */
    public List<DadosFullFutebol> listaDadosFullFutebol() {
        return dadosFullFutebolList;
    }

}
