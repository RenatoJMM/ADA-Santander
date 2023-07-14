import java.util.Scanner;

public class Utils {

    public String lerString(String msg) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(msg);
        String result = scanner.nextLine();

        return result;
    }

    public int lerInt(String msg) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(msg);
        int result = scanner.nextInt();

        return result;
    }

}
