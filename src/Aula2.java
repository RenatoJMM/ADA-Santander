import static utils.Utils.*;

public class Aula2 {

    public static int[] EscolherFruta() {

        System.out.println("\nOpções de Fruta:");
        System.out.println("1- Pera\n2- Laranja\n3- Maçã\n4- Tomate\n5- Caqui\n");

        String msg = "";

        int[] escolha = new int[2];

        msg = "Qual fruta você deseja? (Digite o número)";
        escolha[0] = lerInt(msg);

        msg = "Quantidade: ";
        escolha[1] = lerInt(msg);

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

        boolean continuar = true;
        double resultadoFinal = 0;

        while (continuar) {
            int[] escolha = EscolherFruta();

            if (escolha[1] >= 10) {
                resultadoFinal += escolha[1] * 1.25;
            } else {
                resultadoFinal += escolha[1] * 1.45;
            }

            continuar = comprarMais();
        }

        System.out.printf("Valor final a pagar: %.2f", resultadoFinal);

    }

}
