package Class_3;

import java.math.BigDecimal;

public class A_03_EX_01 {

    public static double custoCompra(double input) {

        double valorFinal = 0.00;

        if (input > 10) {
            valorFinal = input * 1.25;
        } else {
            valorFinal = input * 1.45;
        }

        return valorFinal;
    }

    public static void main(String[] args) {

        double resultado = custoCompra(2);

        System.out.println(resultado);

    }

}
