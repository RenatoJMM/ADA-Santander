package Lecture_7;

public class ThreadDemonstration {

    public static void main(String[] args) {

        System.out.println("Hello World");

        // FIRST WAY OF CREATING A THREAD!
        MinhaThread minhaThread = new MinhaThread("Thread Nova");
        MinhaThread minhaThread2 = new MinhaThread("Thread Nova The Second");
        MinhaThread minhaThread3 = new MinhaThread("Thread Nova The Third");

        minhaThread.start();
        minhaThread2.start();
        minhaThread3.start();
    }
}
