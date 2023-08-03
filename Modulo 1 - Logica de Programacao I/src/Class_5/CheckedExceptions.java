package Class_5;

public class CheckedExceptions {

    public static void main(String[] args) {
        lerClasse("Teste");
    }

    public static void lerClasse(String name) {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {

            System.out.printf("Classe '%s' não encontrada!", name);

        }
    }

}
