package Lecture_6;

public class MethodReferenceProgram {

    public static void getString(String string) {
        System.out.println(string);
    }

    public static void main(String[] args) {

        Impressao impressaoPorLambda = s -> System.out.println(s);

        impressaoPorLambda.getNome("Ronaldo");

        Impressao impressaoPorMethodReference = MethodReferenceProgram::getString;
        // Impressao impressaoPorMethodReference = str -> getString(str);
        impressaoPorMethodReference.getNome("teste do method reference");
    }

}
