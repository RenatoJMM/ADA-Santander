public class Main {

    public static void mostrarTexto(String texto) {
        System.out.println(texto);
    }

    // SÓ UTILIZAR O ATALHO "main" QUE CRIA A FUNCAO PRINCIPAL
    public static void main(String[] args) throws Exception {
        int a = 25;
        short b = 1;

        System.out.println(b);

        // TIPOS DE PRINT
        System.out.println("Hello, World!"); // JÁ DA UM \n O PRINTLN
        System.out.print(a); // ESSE PRINT NÃO PULA LINHA
        System.out.printf("Aqui começa printf: %s, %s", a, b); // PRINT COM POSSIBILIDADE DE FORMATAR STRINGS
        System.out.printf("\nnumero: %.2f, String: %s", 2.5f, "teste");
        System.out.printf("\nnumero: %2.1f, String: %s", 2354654.5368f, "teste"); // ELE MESMO ARREDONDA

        mostrarTexto(" coisa boa! Funcionando!");
    }

}
