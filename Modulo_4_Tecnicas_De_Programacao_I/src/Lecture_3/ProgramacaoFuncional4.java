package Lecture_3;

import java.util.function.BiFunction;

public class ProgramacaoFuncional4 {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> calculadoraSomar = (n1, n2) -> n1 + n2;

        System.out.println(calculadoraSomar.apply(25, 29));
    }

}
