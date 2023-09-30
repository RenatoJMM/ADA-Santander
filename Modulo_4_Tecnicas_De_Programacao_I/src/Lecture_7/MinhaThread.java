package Lecture_7;

public class MinhaThread extends Thread {

    public MinhaThread(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        System.out.println("Hello to the world " + super.getName());
        // super.run();
    }
}
