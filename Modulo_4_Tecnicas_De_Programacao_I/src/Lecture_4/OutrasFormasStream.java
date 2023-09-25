package Lecture_4;

import java.util.Collections;
import java.util.stream.Stream;

public class OutrasFormasStream {

    public static void main(String[] args) {

        // COLEÇAO VAZIA
        Collections.emptyList();

        // STREAM VAZIA
        Stream.empty().map(n -> n + "").forEach(n -> System.out.println(n));
    }

}
