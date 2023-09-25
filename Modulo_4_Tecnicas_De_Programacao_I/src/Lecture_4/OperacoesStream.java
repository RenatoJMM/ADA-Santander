package Lecture_4;

import java.util.Comparator;
import java.util.stream.Stream;

public class OperacoesStream {

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);

        stream1.map(n -> n * 2).filter(n -> n.equals(2)).map(n -> n * 10).forEach(n -> System.out.println(n));

        // remover elementos iguais na Stream
        Stream<String> products = Stream.of("feijao", "arroz", "feijao", "macarrao");

        products.distinct().forEach(n -> System.out.println(n));

        // ordenacao de numeros ns stream
        Stream<Integer> intStream = Stream.of(5, 0, 32, 1);
        intStream.sorted().forEach(n -> System.out.println(n));

        // ordenação de valores por operacao terminal forEachOrdered
        Stream<Integer> newStream = Stream.of(5, 0, 32, 1);
        newStream.forEachOrdered(n -> System.out.println(n));

        // maior elemento da stream
        Stream<Integer> maiorStream = Stream.of(5, 0, 32, 1);
        System.out.println(maiorStream.max(Comparator.naturalOrder()));

        // maior elemento da stream
        Stream<Integer> maiorStream2 = Stream.of(5, 0, 32, 1);
        System.out.println(maiorStream2.max(Comparator.naturalOrder()).get());

        // menor elemento da stream
        Stream<Integer> menorStream = Stream.of(5, 0, 32, 1);
        System.out.println(menorStream.min(Comparator.naturalOrder()).get());
    }

}
