package Lecture_7;

public class MinhaTarefa implements Runnable {

    private String name;

    public MinhaTarefa(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Hello World" + this.name);
    }
}
