package Lecture_3;

import static utils.Utils.*;

public class A_03_EX_06 {

    public static double calcularArea(double[] lados) {

        verificarTriangulo(lados);

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

    public static double[] digitarLados() {
        String[] ordem = { "primeiro", "segundo", "terceiro" };
        double[] lados = new double[3];

        for (int i = 0; i < ordem.length; i++) {
            try {
                String msg = "Digite o " + ordem[i] + " lado:";
                lados[i] = lerDouble(msg);
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                i--;
            }

        }

        return lados;

    }

    public static void main(String[] args) {

        double[] lados = new double[3];

        lados = digitarLados();

        double area = calcularArea(lados);
        System.out.printf("Área: %.2f cm²", area);

    }

}
