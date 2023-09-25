package Lecture_4;

import java.util.stream.Stream;

public class SolucaoStream {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(5, 8, 9, 10, 11);

        stream.map(n -> n * 2).forEach(n -> System.out.println(n));
    }

}
