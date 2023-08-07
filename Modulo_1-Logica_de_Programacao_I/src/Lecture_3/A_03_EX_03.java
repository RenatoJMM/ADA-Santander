package Class_3;

public class A_03_EX_03 {

    public static double calculoSalario(double[] input) {
        double salario = 0;
        double percentTempoServico = 0;
        double ipca = input[1] / 100;

        if (input[0] >= 1 && input[0] < 5) {
            percentTempoServico = 0.01;
        } else if (input[0] >= 5 && input[0] < 10) {
            percentTempoServico = 0.015;
        } else if (input[0] >= 10) {
            percentTempoServico = 0.02;
        }

        System.out.println(ipca);

        salario = Math.round(input[2] * (1 + ipca + percentTempoServico) * 100);
        salario = salario / 100;

        return salario;
    }

    public static void main(String[] args) {

        double[] teste = { 11, 4.5, 2500.00 };

        double resultado = calculoSalario(teste);

        System.out.println(resultado);

    }

}
