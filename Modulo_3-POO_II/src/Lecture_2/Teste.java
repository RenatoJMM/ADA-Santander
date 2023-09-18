package Lecture_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        Caixa<String> caixaDeString = new Caixa<String>("Teste");

        caixaDeString.abrirCaixa();

        Caixa<Integer> caixaDeInteger = new Caixa<>(25);

        caixaDeInteger.abrirCaixa();

        Map<Object, Object> mapa = new HashMap<>();
        mapa.put(3L, "Teste");

        System.out.println(mapa.get(3L));

        // imprimirValor(1, 2, 3, "HEllo"); // PARA DE FUNCIONAR POR QUE O T SÓ ACEITA
        // NÚMEROS( T EXTENDS NUMBER).
        imprimirValor(1, 23, 40);

        List<Integer> li = Arrays.asList(1, 2, 3);

        // printObjectList(li); AQUI QUALQUER OBJETO QUE EU PASSE VAI RECLAMAR, SÓ SE
        // PASSAR OBJECT QUE NÃO, POIS ELE NÃO CONSEGUE IDENTIFICAR
        printWildCardList(li);

    }

    public static <T extends Number> void imprimirValor(T... valores) {
        for (T valor : valores) {
            System.out.println(valor);
        }
    }

    public static void printWildCardList(List<? extends Number> listObject) {
        for (Object obj : listObject) {
            System.out.println(obj);
        }
    }

    public static void printObjectList(List<Object> listObject) {
        for (Object obj : listObject) {
            System.out.println(obj);
        }
    }
}
