package Lecture_6.Homework;

import java.util.Optional;

public class Usuario {

    private String nome;
    private Optional<String> email = Optional.empty();
    private Optional<Integer> idade = Optional.empty();

    public Usuario(String nome, Optional<String> email, Optional<Integer> idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void mostrarDetalhes(){
        String naoEncontrado = "informação indisponível";

        System.out.println("Nome: " + this.nome);

        this.email.ifPresentOrElse(email -> System.out.println("Idade: " + email), () -> System.out.println("E-mail: " + naoEncontrado));

        this.idade.ifPresentOrElse(x -> System.out.println("Idade: " + x), () -> System.out.println("Idade: " + naoEncontrado));

    }
}
