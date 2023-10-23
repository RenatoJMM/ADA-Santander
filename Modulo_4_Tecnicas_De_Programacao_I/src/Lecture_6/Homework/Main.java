package Lecture_6.Homework;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Usuario> listaUsuarios = List.of(new Usuario("Renato"),
                new Usuario("Julia", Optional.empty(),Optional.empty()),
                new Usuario("Julia2", Optional.of("julia@email"),Optional.empty()),
                new Usuario("Renato2", Optional.empty(),Optional.of(15)));

        for (Usuario usuario : listaUsuarios){
            usuario.mostrarDetalhes();
            System.out.println("------------------------");
        }
    }
}
