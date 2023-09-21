package Lecture_3;

import java.util.function.Function;

public class ProgramacaoFuncional2 {

    public static void main(String[] args) {

        String palavra = "Renato";

        ContarCaracteres<String, Integer> contaLetrasR = p -> {
            Integer contador = 0;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    contador++;
                }
            }
            return contador;
        };

        ContarCaracteres<String, Integer> contarCaracteres = p -> p.length();

        System.out.println(conta(palavra, contarCaracteres));
        System.out.println(conta(palavra, contaLetrasR));
        System.out.println(contaLetrasR.execute(palavra));

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Renato");
        strBuilder.append(" Lindo");

        ContarCaracteres<StringBuilder, Integer> contarCaracteres2 = p -> p.length();
        System.out.println(contarCaracteres2.execute(strBuilder));
        System.out.println(strBuilder);

        // INTERFACE FUNCIONAL CRIADA PELO JAVA

        // Function //EXATAMENTE IGUAL A NOSSA INTERFACE CONTARCARACTER (SÓ QUE O
        // EXECUTE É APPLY)

        Function<String, Integer> funcContCarac = p -> p.length();
        System.out.println(funcContCarac.apply(palavra));

    }

    public static int conta(String palavra, ContarCaracteres<String, Integer> func) {
        return func.execute(palavra);
    }
}
