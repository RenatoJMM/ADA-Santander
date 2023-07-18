public class EX_03_04 {

    public static int primeiroCaractereUnico(String input) {
        input = input.toUpperCase();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    result = 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int resultado = primeiroCaractereUnico("cOCADa");

        System.out.println(resultado);

    }

}
