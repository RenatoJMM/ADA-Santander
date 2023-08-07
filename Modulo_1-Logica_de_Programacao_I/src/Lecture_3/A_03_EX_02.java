package Class_3;

public class A_03_EX_02 {

    public static double[] custosCarro(double[] input) {

        double[] porcentagens = new double[2];

        porcentagens[0] = Math.round(input[1] / input[0] * 10000);
        porcentagens[1] = Math.round(input[2] / input[0] * 10000);

        porcentagens[0] = porcentagens[0] / 100;
        porcentagens[1] = porcentagens[1] / 100;

        return porcentagens;
    }

    public static void main(String[] args) {

        double[] resultados = new double[2];
        double[] teste = { 238500, 18350, 32450 };

        resultados = custosCarro(teste);

        for (int i = 0; i < 2; i++) {
            System.out.println(resultados[i]);
        }

    }

}
