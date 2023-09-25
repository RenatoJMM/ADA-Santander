package Lecture_4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CollectionVsStream {

    public static void main(String[] args) {

        Stream<Integer> intStream = Stream.of(5, 0, 32, 1);
        intStream.sorted().forEach(n -> System.out.println(n));

        // UTILIZANDO COLLECTIONS
        List<Integer> listInt = List.of(1, 2, 3);
        listInt.stream().forEach(n -> System.out.println(n));
        // A STREAM FECHA ALI MAS A LISTA CONTINUA, MAS POSSO SALVAR ESSA STREAM EM
        // OUTRA VARIAVEL

        System.out.println(listInt.stream().min(Comparator.naturalOrder()));
    }

}