package Class_3;

public class A_03_EX_05 {

    public static boolean elementosRepetidos(double[] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // double[] input = { 2.5, 3.2, 4.5, 5, 6 };
        double[] input = { 2, 2, 3.1, 4, 4.1, 4.1 };

        System.out.println(elementosRepetidos(input));

    }

}
