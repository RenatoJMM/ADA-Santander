package Lecture_8;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemonstration4 {

    public static void main(String[] args) {

        Runnable minhaTarefa = () -> {

            for (int i = 1; i < 7; i++) {
                Random gerador = new Random();
                int tempo = (gerador.nextInt(9) + 1) * 1000;

                try {
                    Thread.sleep(tempo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(" Execution number: " + i);
            }
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(minhaTarefa);

    }

}
