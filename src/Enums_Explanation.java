public class Enums_Explanation {

    public static void main(String[] args) {

        // OPENFINANCE ENUMS PRATICAR

        System.out.println(diaDaSemanana("Sabado"));
        System.out.println(diaDaSemanana2(Semana.SABADO));
        System.out.println(Semana.TERCA_FEIRA.getName());

    }

    public static int diaDaSemanana(String dia) {
        if (dia.equals("Domingo")) {
            return 0;
        } else if (dia.equals("Segunda")) {
            return 1;
        } else if (dia.equals("Terça")) {
            return 2;
        } else if (dia.equals("Quarta")) {
            return 3;
        } else if (dia.equals("Quinta")) {
            return 4;
        } else if (dia.equals("Sexta")) {
            return 5;
        } else if (dia.equals("Segunda")) {
            return 1;
        } else if (dia.equals("Sabado")) {
            return 6;
        }

        return -1;

    }

    public static int diaDaSemanana2(Semana dia) {
        return dia.ordinal();
    }

}
