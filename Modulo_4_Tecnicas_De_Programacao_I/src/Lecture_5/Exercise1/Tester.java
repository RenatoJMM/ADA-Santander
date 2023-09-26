package Lecture_5.Exercise1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tester {

    public static void main(String[] args) {

        List<Produto> produtos = Arrays.asList(new Produto("Notebook", 2500.0, 10), new Produto("Impressora", 800.0, 5),
                new Produto("Mouse", 50.0, 20), new Produto("Teclado", 100.0, 15));

        System.out.println("Products priced above 500: ");
        produtos.stream().filter(p -> (p.getPreco() > 500)).forEach(p -> System.out.println(p));

        System.out.println("\nPrice of products in order (price ascending): ");
        produtos.stream().map(p -> p.getPreco()).sorted().forEach(p -> System.out.println(p));

        System.out.println("\nCheapest product: ");
        System.out.println(produtos.stream().map(p -> p.getPreco()).min(Comparator.naturalOrder()).get());

        System.out.println("\nProducts with 10 or less units in stock: ");
        produtos.stream().filter(p -> (p.getQuantidade() <= 10)).forEach(p -> System.out.println(p));

    }

}
