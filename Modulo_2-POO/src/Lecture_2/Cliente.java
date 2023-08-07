package Lecture_2;

public class Cliente {

    String nome;
    String cpf;
    String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    @Override
    public boolean equals(Object c) {
        if (c instanceof Cliente clienteComparar) {
            if (clienteComparar.cpf.equals(this.cpf)) {
                return true;
            }
        }

        return false;

    }

    @Override
    public String toString() {
        return "Cliente: " + this.nome + ", CPF: " + this.cpf + ", email: " + this.email + ".";
    }

}
