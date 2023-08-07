package Lecture_1;

import java.util.ArrayList;

public class Agenda {
    ArrayList<Contato> contatos;

    public Agenda(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public void deletar(String nome) {
        for (int i = 0; i < contatos.size(); i++) {

            if (contatos.get(i).nome.equals(nome)) {
                contatos.remove(i);
            }

        }
        System.out.printf("%s - Deletado de contatos!\n", nome);
    }

    public void buscar(String nome) {

        for (int i = 0; i < contatos.size(); i++) {

            if (contatos.get(i).nome.equals(nome)) {
                System.out.println("Nome: " + contatos.get(i).nome);
                System.out.println("Numero: " + contatos.get(i).numero);
            } else {
                System.out.println("Não encontrado!");
            }

        }

    }

    public void mostrarAgenda() {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("Nome: " + contatos.get(i).nome + ", Número: " + contatos.get(i).numero);
        }
    }

}
