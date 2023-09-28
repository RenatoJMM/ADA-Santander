package Lecture_6;

public class ExemploInstanceMethodReference {

    public static void main(String[] args) {
        Verificador verificadorLambda = n -> n % 2 == 0;

        System.out.println(verificadorLambda.verificaSeEPar(6));

        var instanceMethodReference = new ExemploInstanceMethodReference();
        Verificador verificadorMethodReference = instanceMethodReference::verifica;
        System.out.println(verificadorMethodReference.verificaSeEPar(10));
    }

    public boolean verifica(Integer num) {
        return num % 2 == 0;
    }

}
