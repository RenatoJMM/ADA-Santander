package Lecture_3.Utils;

public class ValidaSenha {

    private ValidaSenha() {

    }

    public static boolean validar(String senhaAtual, String senha) {
        return senhaAtual.equalsIgnoreCase(Criptografia.criptografar(senha));
    }

}
