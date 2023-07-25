import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class A_06_EX_02 {

    public static void main(String[] args) throws EstadoInvalidoException {

        System.out.println(valorProdutoFinal(250.10, "MG") == 267.607);
        System.out.println(valorProdutoFinal(250.10, "RJ") == 287.615);
        System.out.println(valorProdutoFinal(250.10, "SP") == 280.112);
        try {
            System.out.println(valorProdutoFinal(250.10, "DF") == 280.112);
        } catch (EstadoInvalidoException e) {
            throw new EstadoInvalidoException("Estado Inválido!");
        }

    }

    public static double valorProdutoFinal(double valorProduto, String sigla) throws EstadoInvalidoException {

        Estado estado = Estado.valueOf(sigla);

        double valorFinal = valorProduto * (1.0 + estado.getTax());
        valorFinal = arredondar(valorFinal);

        return valorFinal;

    }

    public static double arredondar(double numero) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.####", symbols);
        return Double.parseDouble(decimalFormat.format(numero));
    }

}
