package Class_7;

public class A_07_EX_02 {

    public static void main(String[] args) {
        System.out.println(somar(5));
        System.out.println(fatorial(6));
        System.out.println(fatorialrecursivo(6));
    }

    public static int somar(int limite) {
        if (limite == 0) {
            return 0;
        }

        return limite + somar(limite - 1);
    }

    public static int fatorial(int limite) {

        int result = 1;
        for (int i = limite; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    public static int fatorialrecursivo(int limite) {
        if (limite == 0) {
            return 1;
        }

        return limite * fatorial(limite - 1);
    }

}
