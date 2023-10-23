package Lecture_6;


public class ExampleStaticMethodReference {

    public static boolean verifica(Integer num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {

        Verificador verificadorLambda = n -> n % 2 == 0;

        System.out.println(verificadorLambda.verificaSeEPar(6));

        Verificador verificaMethodReference = ExampleStaticMethodReference::verifica;
        System.out.println(verificaMethodReference.verificaSeEPar(6));

    }

}
