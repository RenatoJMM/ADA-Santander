package Class_4;

public class A_04_EX_06 {

    public static void main(String[] args) {
        double[][] entradas = { { 2.5, 3.2, 4.5, 5, 6 }, { 2.5, 2.5, 4.5, 6, 6 }, { 1, 2, 4, 5, 6, 7, 7, 8, 8, 2, 1 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 13, 14, 15 }, { 1, 2, 3, 4, 9, 10, 11, 21, 20, 1, 31 }, { 1 },
                { 1.55, 1.56, 1.57, 1.58, 1.59, 1.58 }, { 1.55, 1.56, 1.57, 1.58, 1.59, 1.589 },
                { 1.5555, 1.565, 1.57, 1.58, 1.59, 1.5895 }, };

        boolean[] saidas = { false, true, true, false, true, false, true, false, false, };

        for (int i = 0; i < entradas.length; i++) {
            boolean resultado = elementosRepetidos(entradas[i]);
            boolean esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static boolean elementosRepetidos(double[] input) {
        // Faça utilizando while

        boolean result = false;
        int count = 0;
        int count2 = 0;

        while (count < input.length) {

            count2 = count + 1;

            while (count2 < input.length) {

                if (input[count] == input[count2]) {
                    result = true;
                }

                count2++;
            }

            count++;
        }

        return result;
    }

}
