package Lecture_2;

import java.util.HashMap;
import java.util.Map;

public class Teste {

    public static void main(String[] args) {

        Caixa<String> caixaDeString = new Caixa<String>("Teste");

        caixaDeString.abrirCaixa();

        Caixa<Integer> caixaDeInteger = new Caixa<>(25);

        caixaDeInteger.abrirCaixa();

        Map<Object, Object> mapa = new HashMap<>();
        mapa.put(3L, "Teste");

    }

}
