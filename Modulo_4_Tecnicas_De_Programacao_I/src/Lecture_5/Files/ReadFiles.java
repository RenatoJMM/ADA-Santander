package Lecture_5.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFiles {

    public static void main(String[] args) throws IOException {
        // READ FILE employees.csv

        Path path = Paths.get("src/Lecture_5/FileCsv/employee.csv");

        Stream<String> lines = Files.lines(path);

        // lines.forEach(p -> System.out.println(p));
        // lines.forEach(System.out::println);

        List<Funcionario> listaFunc = new ArrayList<>();

        lines.forEach(string -> {
            String[] funcionarioString = string.split(","); // separa através da virgula
            // System.out.println(Arrays.toString(funcionarioString));// CONSEGUIMOS VER QUE
            // SEPARAOU AS INFORMAÇOES

            Funcionario func = new Funcionario(Integer.parseInt(funcionarioString[0]), funcionarioString[1],
                    funcionarioString[2], LocalDate.parse(funcionarioString[3]), funcionarioString[4],
                    funcionarioString[5], LocalDate.parse(funcionarioString[6]),
                    Double.parseDouble(funcionarioString[7]));

            listaFunc.add(func);

        });

        System.out.println("Numero de funcionários: " + listaFunc.size());
        System.out.println("Numero de funcionários: " + listaFunc.stream().count());
        System.out.println("Funcionários ordenados: ");
        listaFunc.stream().sorted(Comparator.comparing(Funcionario::getId)).forEach(p -> System.out.println(p));

        System.out.println("\nPegar uma lista dos nomes dos funcionários. ");
        List<String> nomesFuncs = listaFunc.stream().map(f -> f.getNome()).collect(Collectors.toList());
        System.out.println(nomesFuncs);

        System.out.println("\nPegar uma conjunto com o nome dos funcionários. ");
        Set<String> conjFunc = listaFunc.stream().map(f -> f.getNome()).collect(Collectors.toSet()); // collect agrega
                                                                                                     // os elementos da
                                                                                                     // stream |
                                                                                                     // transformar a
                                                                                                     // stream em outra
                                                                                                     // coisa(lista,set,map,)
        System.out.println(nomesFuncs);

        System.out.println("\nMapa com ID e nome do funcionário. ");
        Map<Integer, String> mapaFuncs = listaFunc.stream().collect(Collectors.toMap(p -> p.getId(), p -> p.getNome()));
        System.out.println(mapaFuncs);
        System.out.println(mapaFuncs.get(27827));

        System.out.println("\nNomes de todos os funcionários em String: ");
        String allNames = listaFunc.stream().map(p -> p.getNome()).collect(Collectors.joining(","));

        System.out.println(allNames);

        System.out.println("\nQuantidade de funcionários por cargo: ");
        Map<String, Long> mapaGroupCargo = listaFunc.stream()
                .collect(Collectors.groupingBy(p -> p.getCargo(), Collectors.counting()));
        System.out.println(mapaGroupCargo);

        System.out.println("\nSoma de salários por cargo: ");
        Map<String, Double> mapaGroupSalario = listaFunc.stream()
                .collect(Collectors.groupingBy(p -> p.getCargo(), Collectors.summingDouble(p -> p.getSalario())));
        System.out.println(mapaGroupSalario);

        System.out.println("\n Agrupando por id - nome, salário");
        Map<Integer, Funcionario> mapaPersonalizado = listaFunc.stream()
                .collect(Collectors.toMap(Funcionario::getId, f -> new Funcionario(f.getNome(), f.getSalario())));
        System.out.println(mapaPersonalizado);
    }

}
