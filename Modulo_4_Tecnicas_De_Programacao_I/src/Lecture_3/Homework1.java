package Lecture_3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Homework1 {

    public static void main(String[] args) {

        Function<List<Produto>, Double> somarProdutos = p -> {
            Double sum = 0.0;

            for (Produto produto : p) {
                sum = sum + produto.getPreco();
            }
            return sum;
        };

        List<Produto> listProd = new ArrayList<>();

        Produto feijao = new Produto("feijoa", 10.20);
        Produto arroz = new Produto("arroz", 20.50);
        Produto picanha = new Produto("picanha", 60.99);
        Produto coca = new Produto("Coca", 7.99);

        Collections.addAll(listProd, feijao, arroz, picanha, coca);

        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("Carrinho de Compras:");

        for (Produto produto : listProd) {
            System.out.println("Produto: " + produto.getNome() + ", Preço: " + produto.getPreco());
        }

        System.out.println("\nPreço total: " + df.format(somarProdutos.apply(listProd)));
    }

}
