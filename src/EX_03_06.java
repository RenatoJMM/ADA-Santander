public class EX_03_06 {

    public static double calcularArea(double a, double b, double c) {
        double area = 0;

        double p = (a + b + c) / 2;

        area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return area;
    }

    public static void main(String[] args) {

        // VALOR EM CENTIMÉTROS

        double area = calcularArea(9, 7, 14);

        System.out.printf("Área: %.2f cm²", area);

    }

}
