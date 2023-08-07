package Lecture_4;

public class A_04_EX_05 {

    public static void main(String[] args) {
        String[] entradas = { "amor", "cocada", "mora", "ovo", "cachorro", "kaka", "saudades", "palalelepipedo",
                "fofocalizando", "papagaio", "ateiaateiab" };

        int[] saidas = { 0, 1, 0, 1, 1, -1, 2, 9, 4, 4, 10 };

        for (int i = 0; i < entradas.length; i++) {
            double resultado = primeiroCaractereUnico(entradas[i]);
            double esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static int primeiroCaractereUnico(String input) {
        // Faça utilizando for

        int result = -1;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {

            count = 0;

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    count += 1;
                }
            }

            if (count == 1) {
                result = i;
                break;
            }
        }

        return result;

    }

}
