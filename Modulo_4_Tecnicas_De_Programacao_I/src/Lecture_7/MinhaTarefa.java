package Lecture_7;

import java.util.Random;

public class MinhaTarefa implements Runnable {

    private String name;

    public MinhaTarefa(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 1; i < 7; i++) {
            Random gerador = new Random();
            int tempo = (gerador.nextInt(9) + 1) * 1000;

            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Hello World" + this.name + " Execution number: " + i);
        }

    }
}
