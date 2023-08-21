package Lecture_7;

public class Tester {

    public static void main(String[] args) {
        MinhaPilha lista1 = new MinhaPilha();

        System.out.println("TESTE");

        lista1.PUSH(1);
        lista1.PUSH("dois");
        lista1.PUSH(78);
        lista1.PUSH(false);

        lista1.PEEK();
        lista1.POP();
        lista1.PEEK();
    }

}
