package Lecture_3;

public class ProgramacaoFuncional {

    public static void main(String[] args) {

        Integer num1 = 1;
        Integer num2 = 2;

        Operacao operacaoSomar = new OperacaoSomar();
        Operacao operacaoSubtrair = new OperacaoSubtrair();

        System.out.println(calcular(num1, num2, operacaoSomar));
        System.out.println(calcular(num1, num2, operacaoSubtrair));

        // MÉTODO ANÔNIMO
        // SÓ FUNCIONA EM UMA INTERFACE FUNCIONAL (APENAS UM MÉTODO ABSTRATO)
        Operacao operacaoLambdaSomar = (Integer a, Integer b) -> {
            return a + b;
        };

        Operacao operacaoLambdaSubtrair = (a, b) -> a - b; // OUTRA SINTAXE

        System.out.println(calcular(num1, num2, operacaoLambdaSomar));
        System.out.println(calcular(num1, num2, operacaoLambdaSubtrair));

    }

    private static Integer calcular(Integer num1, Integer num2, Operacao operacao) {

        return operacao.execute(num1, num2);
    }

}
