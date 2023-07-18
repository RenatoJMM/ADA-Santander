public class EX_03_06 {

    public static double calcularArea(double[] lados) {
        double area = 0;
        double sum = 0;

        for (int i = 0; i < lados.length; i++) {
            sum += lados[i];
        }

        double p = (sum) / 2;

        area = Math.sqrt(p * (p - lados[0]) * (p - lados[1]) * (p - lados[2]));

        return area;
    }

    public static boolean verificarTriangulo(double[] lados) {
        double maior = lados[0];
        int indice = 0;
        double sum = 0;

        for (int i = 0; i < lados.length; i++) {

            if (maior < lados[i]) {
                maior = lados[i];
                indice = i;
            }

        }

        for (int i = 0; i < lados.length; i++) {
            if (indice != i) {
                sum += lados[i];
            }
        }

        if (sum > maior) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public static void main(String[] args) {

        // VALOR EM CENTIMÉTROS
        double[] lados = { 5, 3, 9 };
        verificarTriangulo(lados);
        double area = calcularArea(lados);
        System.out.printf("Área: %.2f cm²", area);

    }

}
