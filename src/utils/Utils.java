package utils;

import java.util.Scanner;

public class Utils {

    public static String lerString(String msg) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(msg);
        String result = scanner.nextLine();

        return result;
    }

    public static int lerInt(String msg) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(msg);
        int result = scanner.nextInt();

        return result;
    }

}
