package Lecture_2;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
