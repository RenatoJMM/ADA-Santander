package Lecture_6;

import Lecture_6.contrato.Lista;
import Lecture_6.impl.ArrayLista;
import Lecture_6.impl.ListaLigada;

public class Principal {

    public static void main(String[] args) {

        Lista lista = new ArrayLista();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        lista.add(10);

        imprimirLista(lista);

        lista.remove(1);
        System.out.println();
        imprimirLista(lista);

        Lista lista1 = new ListaLigada();
        lista1.add("primeiro elemento");
        lista1.add("segundo elemento");
        lista1.add(1);
        lista1.add(2);

        imprimirLista(lista1);

        lista1.remove(3);

        imprimirLista(lista1);
    }

    public static void imprimirLista(Lista lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

}
