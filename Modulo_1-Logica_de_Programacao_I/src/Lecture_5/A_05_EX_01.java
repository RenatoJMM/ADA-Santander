package Class_5;

public class A_05_EX_01 {

    public static void main(String[] args) {

        double resultado = custoCompra(-1);

        System.out.println(resultado);
    }

    public static double custoCompra(double input) throws IllegalArgumentException {

        double valorFinal = 0.00;

        if (input > 10) {
            valorFinal = input * 1.25;
        } else if (input > 0 && input <= 10) {
            valorFinal = input * 1.45;
        } else if (input == 0) {
            throw new CompraInvalidaException("Não é possível realizar pedido com zero items!");
        } else if (input < 0) {
            throw new CompraInvalidaException("Quantidade Fornecida inválida (Negativa)!!");
        }

        return valorFinal;
    }

}
