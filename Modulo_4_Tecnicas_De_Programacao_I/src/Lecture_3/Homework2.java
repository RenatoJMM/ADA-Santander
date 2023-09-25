package Lecture_3;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Homework2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BiFunction<Integer, Integer, Integer> somar = (n1, n2) -> {
            return n1 + n2;
        };

        BiFunction<Integer, Integer, Integer> subtrair = (n1, n2) -> {
            return n1 - n2;
        };

        BiFunction<Integer, Integer, Integer> multiplicar = (n1, n2) -> {
            return n1 * n2;
        };

        BiFunction<Integer, Integer, Integer> dividir = (n1, n2) -> {
            return n1 / n2;
        };

        System.out.println("Digite o primeiro valor: ");
        Integer num1 = scanner.nextInt();

        System.out.println("Digite o segundo valor: ");
        Integer num2 = scanner.nextInt();

        System.out.println("\nOperação Desejada: ");
        System.out.println("1- Somar");
        System.out.println("2- Subtrair");
        System.out.println("3- Multiplicar");
        System.out.println("4- Dividir");

        Integer opcao = scanner.nextInt();

        System.out.println("\nResultado:");

        switch (opcao) {
            case 1:
                System.out.println(Calculadora.executar(num1, num2, somar));
                break;
            case 2:
                System.out.println(Calculadora.executar(num1, num2, subtrair));
                break;
            case 3:
                System.out.println(Calculadora.executar(num1, num2, multiplicar));
                break;
            case 4:
                System.out.println(Calculadora.executar(num1, num2, dividir));
                break;
            default:
                System.out.println("ERROR!");
        }
        scanner.close();

    }

    public class Calculadora {
        public static Integer executar(Integer num1, Integer num2, BiFunction<Integer, Integer, Integer> func) {
            return func.apply(num1, num2);
        }
    }

}
