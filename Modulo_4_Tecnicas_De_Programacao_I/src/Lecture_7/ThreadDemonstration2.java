package Lecture_7;

public class ThreadDemonstration2 {

    public static void main(String[] args) {

        String nomeThread = "##Thread 1";

        MinhaTarefa minhaTarefa = new MinhaTarefa(nomeThread);

        Thread thread = new Thread(minhaTarefa);
        thread.start();
    }

}
