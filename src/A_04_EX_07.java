public class A_04_EX_07 {

    public static void main(String[] args) {
        int[][] entradas = { { 2, 2, 5 }, { 3, 3, 5 }, { 2, 2, 2 }, { 2, 5, 2 }, { 2, 4, 3 }, { 150, 120, 220 },
                { 122, 252, 130 }, { 152, 200, 351 }, { 1232, 2200, 120 }, { 1, 2, 1 }, { 2, 1, 2 } };

        String[] saidas = { "LadosInvalidosException", "true", "true", "LadosInvalidosException", "true", "true",
                "LadosInvalidosException", "true", "LadosInvalidosException", "LadosInvalidosException", "true" };

        for (int i = 0; i < entradas.length; i++) {
            String resultado = "true";

            try {
                eUmTriangulo(entradas[i]);
            } catch (LadosInvalidosException e) {
                resultado = "LadosInvalidosException";
            }
            String esperado = saidas[i];

            System.out.println("Resultado: " + resultado);
            System.out.println("Esperado: " + esperado);
            System.out.println(resultado == esperado);
            System.out.println();
        }
    }

    public static void eUmTriangulo(int[] input) throws LadosInvalidosException {

        double maior = input[0];
        int indice = 0;
        double sum = 0;

        for (int i = 0; i < input.length; i++) {
            if (maior < input[i]) {
                maior = input[i];
                indice = i;
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (indice != i) {
                sum += input[i];
            }
        }

        if (maior > sum) {
            throw new LadosInvalidosException("Não é um triângulo!");
        }

    }

}
