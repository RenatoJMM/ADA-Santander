package Lecture_7;

import java.util.List;

public class ThreadDemonstration2 {

    public static void main(String[] args) {

        String nomeThread = "##Thread 1";

        // ESSA LISTA PODE SER TIPO RUNNABLE TB (IMPLEMENTS RUNNABLE MINHATAREGA)
        List<MinhaTarefa> minhasTarefas = List.of(new MinhaTarefa(nomeThread), new MinhaTarefa("##Thread 2"),
                new MinhaTarefa("##Thread 3"));

        for (MinhaTarefa minhaTarefa : minhasTarefas) {
            Thread thread = new Thread(minhaTarefa);
            thread.start();
        }
    }

}
