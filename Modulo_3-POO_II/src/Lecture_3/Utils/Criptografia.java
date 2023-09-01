package Lecture_3.Utils;

import java.util.Base64;

public class Criptografia {

    private Criptografia() {

    }

    public static String criptografar(String senha) {
        return Base64.getEncoder().encodeToString(senha.getBytes());
    }

    public static String descriptografar(String senhaCriptografada) {
        byte[] decodedBytes = Base64.getDecoder().decode(senhaCriptografada);
        return new String(decodedBytes);
    }
}
