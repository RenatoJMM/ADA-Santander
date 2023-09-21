package Lecture_3;

import java.util.List;
import java.util.function.Function;

public class ProgramacaoFuncional3 {

    public static void main(String[] args) {

        Function<List<Integer>, Integer> sumVal = l -> {
            Integer soma = 0;
            for (Integer val : l) {

                soma += val;

            }

            return soma;
        };

        List<Integer> lista = List.of(1, 2, 3, 4, 5);

        System.out.println("Soma da lista: " + sumVal.apply(lista));

    }

}
