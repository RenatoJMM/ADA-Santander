import java.util.Scanner;

public class Aula2 {

    public static int[] EscolherFruta() {
        System.out.println("\nOpções de Fruta:");
        System.out.println("1- Pera\n2- Laranja\n3- Maçã\n4- Tomate\n5- Caqui\n");

        int[] escolha = new int[2];
        System.out.println("Qual fruta você deseja? (Digite o número)");
        Scanner scanner = new Scanner(System.in);
        escolha[0] = scanner.nextInt();

        System.out.println("Quantidade: ");
        escolha[1] = scanner.nextInt();

        return escolha;
    }

    public static boolean comprarMais() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja comprar mais frutas? (S/N)");
        String choice = scanner.next();

        if (choice.equals("S")) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        boolean continuar = true;
        double valorFinal = 0;

        while (continuar) {
            int[] escolha = EscolherFruta();

            if (escolha[1] >= 10) {
                valorFinal += escolha[1] * 1.25;
            } else {
                valorFinal += escolha[1] * 1.45;
            }

            continuar = comprarMais();
        }

        System.out.printf("Valor final a pagar: %.2f", valorFinal);

    }

}
