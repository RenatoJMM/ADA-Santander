package Aula1;

import java.util.ArrayList;
import java.util.Collections;

public class A_01_EX_01 {

    public static void main(String[] args) {

        Contato renato = new Contato("Renato", "123456789");
        Contato jose = new Contato("Jose", "987654321");
        Contato maria = new Contato("Maria", "45679213");

        ArrayList<Contato> lista = new ArrayList<Contato>();
        Collections.addAll(lista, renato, jose, maria);

        Agenda agenda = new Agenda(lista);

        System.out.println("\nAgenda:");
        agenda.mostrarAgenda();
        System.out.println("");
        renato.detalhar();
        renato.ligar();
        renato.verNumero();
        agenda.buscar("Renato");
        agenda.deletar("Jose");
        agenda.buscar("Jose");
        System.out.println("\nAgenda:");
        agenda.mostrarAgenda();
    }

}
