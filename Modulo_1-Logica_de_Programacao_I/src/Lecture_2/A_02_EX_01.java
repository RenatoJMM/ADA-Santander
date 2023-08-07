package Class_2;

import static utils.Utils.*;

public class A_02_EX_01 {

    public static int[] EscolherFruta(String[] frutas) {

        System.out.println("\nOpções de Fruta:");
        System.out.println("1- Pera\n2- Laranja\n3- Maçã\n4- Tomate\n5- Caqui\n");

        String msg = "";

        int[] escolha = new int[5];

        for (int i = 0; i < frutas.length; i++) {

            msg = String.format("Quantidade de %s desejada: ", frutas[i]);
            escolha[i] = lerInt(msg);

            // if (!comprarMais()) {
            // break;
            // }
        }

        return escolha;
    }

    public static boolean comprarMais() {

        String msg = "";

        msg = "Deseja comprar mais frutas? (S/N)";
        String choice = lerString(msg);

        if (choice.equals("S")) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        double resultadoFinal = 0;
        double resultadoInd = 0;

        String[] frutas = { "Pera", "Laranja", "Maçã", "Tomate", "Caqui" };

        int[] escolha = EscolherFruta(frutas);

        for (int i = 0; i < escolha.length; i++) {

            if (escolha[i] >= 10) {
                resultadoInd = escolha[i] * 1.25;
                resultadoFinal += resultadoInd;
            } else {
                resultadoInd = escolha[i] * 1.25;
                resultadoFinal += resultadoInd;
            }

            System.out.printf("\nFruta: %s\n", frutas[i]);
            System.out.printf("Quantidade: %d\n", escolha[i]);
            System.out.printf("Valor: %.2f\n", resultadoInd);

        }

        System.out.printf("\nValor final a pagar: %.2f", resultadoFinal);

    }

}
