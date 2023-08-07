package Class_5;
public class Unchecked_Exceptions {

    public static void main(String[] args) {

        // UNCHECKED NÃO DÃO ERRO DE COMPILAÇÃO SÓ DE EXECUÇÃO (RUNRIMEEXCEPTION)
        // JÁ AS CHECKED (EXCEPTION) TEM QUE SER TRATADA, POIS DA ERRO DE COMPILAÇÃO
        String valor = "a";

        try {
            int resultado = stringParaInteiro(valor);
            // int divisao = resultado / 0;

        } catch (NumberFormatException e) {
            System.out.println("Não é possível transformar '" + valor + "' para inteiro.");
        } catch (ArithmeticException e) {
            System.out.println("Não é possível dividir por 0!");
        }

    }

    public static int stringParaInteiro(String num) {
        return Integer.parseInt(num);
    }

}
