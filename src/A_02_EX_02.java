import java.util.Arrays;

public class A_02_EX_02 {

    public static void main(String[] args) {
        int[] numbers = { 10, 15, 1, 25, 3 };
        int[] ascendingOrder = sortAscendingOrder(numbers);
        int[] descendingOrder = sortDescendingOrder(numbers);
        int[] pares = retornaPares(numbers);
        int[] impares = retornaImpares(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(ascendingOrder));
        System.out.println(Arrays.toString(descendingOrder));
    }

    public static int[] sortAscendingOrder(int[] lista) {
        int[] listaOrdenada = new int[5];
        int maior = 0;

        for (int i = 0; i < 5; i++) {
            int contador = 0;

            for (int j = 0; j < 5; j++) {
                maior = lista[i];

                if (maior > lista[j]) {
                    contador += 1;
                }

            }

            listaOrdenada[contador] = maior;

        }

        return listaOrdenada;
    }

    public static int[] sortDescendingOrder(int[] lista) {
        int[] listaOrdenada = new int[5];
        int menor = 0;

        for (int i = 0; i < 5; i++) {

            int contador = 0;

            for (int j = 0; j < 5; j++) {
                menor = lista[i];

                if (menor < lista[j]) {
                    contador += 1;
                }

            }

            listaOrdenada[contador] = menor;

        }

        return listaOrdenada;
    }

    public static int[] retornaPares(int[] lista) {

        int count = 0;

        for (int i = 0; i < lista.length; i++) {

            if (lista[i] % 2 == 0) {
                count += 1;
            }

        }

        int[] result = new int[count];

        for (int i = 0; i < lista.length; i++) {

            if (lista[i] % 2 == 0) {
                result += lista[i];
            }
        }

        return result;
    }

    public static int[] retornaImpares(int[] lista) {

        int count = 0;

        for (int i = 0; i < lista.length; i++) {

            if (lista[i] % 2 != 0) {
                count += 1;
            }

        }

        int[] result = new int[count];

        for (int i = 0; i < lista.length; i++) {

            if (lista[i] % 2 != 0) {
                result[i] = lista[i];
            }
        }

        return result;
    }

}
