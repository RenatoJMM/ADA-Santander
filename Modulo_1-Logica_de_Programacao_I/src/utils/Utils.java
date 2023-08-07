package utils;

import java.util.Scanner;

public class Utils {

    public static String lerString(String msg) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(msg);
        String resultado = scanner.nextLine();

        return resultado;
    }

    public static int lerInt(String msg) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(msg);
        int resultado = scanner.nextInt();

        return resultado;
    }

    public static double lerDouble(String msg) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(msg);
        double resultado = scanner.nextDouble();

        return resultado;
    }

}
