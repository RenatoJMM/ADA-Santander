package Lecture_6;

public class Usuario {

    private String senha;

    private String login;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



}
