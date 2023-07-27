public class A_07_EX_02 {

    public static void main(String[] args) {
        System.out.println(somar(5));
        System.out.println(fatorial(5));
    }

    public static int somar(int limite) {
        if (limite == 0) {
            return 0;
        }

        return limite + somar(limite - 1);
    }

    public static int fatorial(int limite) {
        if (limite == 0) {
            return 1;
        }

        return limite * fatorial(limite - 1);
    }

}
