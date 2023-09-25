package Lecture_4.Homework1;

import java.util.List;

public class Tester {

    public static void main(String[] args) {

        List<Produto> produtos = List.of(new Produto("Notebook", "Eletrônicos"), new Produto("Camisa", "Vestuário"),
                new Produto("Smartphone", "Eletrônicos"), new Produto("Tênis", "Calçados"));

        produtos.stream().filter(n -> n.getCategoria().equals("Vestuário"))
                .forEach(n -> System.out.println("Produto: " + n.getNome()));

    }

}
