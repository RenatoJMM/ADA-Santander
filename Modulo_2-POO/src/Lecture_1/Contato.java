package Lecture_1;

public class Contato {

    String nome;
    String numero;

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public void ligar() {
        System.out.println("Ligando para " + nome);
        System.out.println("Num: " + numero);

    }

    public void detalhar() {
        System.out.println("Nome: " + nome);
        System.out.println("Número: " + numero);
    }

    public void verNumero() {
        System.out.printf("Número do contato %s é: %s.", nome, numero);
    }

}
