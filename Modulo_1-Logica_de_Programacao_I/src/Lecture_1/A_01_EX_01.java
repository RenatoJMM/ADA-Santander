package Lecture_1;

import java.util.Scanner;

public class A_01_EX_01 {

    public static void mostrarTexto(String texto) {
        System.out.println(texto);
    }

    public static double fahrenheitParaCelsius(double temp) {
        double celsius = 5 * ((temp - 32) / 9);
        return celsius;
    }

    // SÓ UTILIZAR O ATALHO "main" QUE CRIA A FUNCAO PRINCIPAL
    public static void main(String[] args) throws Exception {
        // int a = 25;
        // short b = 1;

        // System.out.println(b);

        // // TIPOS DE PRINT
        // System.out.println("Hello, World!"); // JÁ DA UM \n O PRINTLN
        // System.out.print(a); // ESSE PRINT NÃO PULA LINHA
        // System.out.printf("Aqui começa printf: %s, %s", a, b); // PRINT COM
        // POSSIBILIDADE DE FORMATAR STRINGS
        // System.out.printf("\nnumero: %.2f, String: %s", 2.5f, "teste");
        // System.out.printf("\nnumero: %2.1f, String: %s", 2354654.5368f, "teste"); //
        // ELE MESMO ARREDONDA

        // mostrarTexto(" coisa boa! Funcionando!");

        // EXERCÍCIO 1
        // ENUNCIADO:
        // Faça um Programa que peça a temperatura em graus Fahrenheit, transforme e
        // mostre a temperatura em graus Celsius. C = 5 * ((F-32) / 9).

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a temperatura em Fahrenheit que deseja ser transformada para graus Celsius:");
        double temp = scanner.nextDouble();

        double result = fahrenheitParaCelsius(temp);
        System.out.printf("Temperatura em graus Celsius: %.1f", result);

    }

}
