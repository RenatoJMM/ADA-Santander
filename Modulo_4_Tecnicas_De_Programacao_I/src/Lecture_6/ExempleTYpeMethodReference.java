package Lecture_6;

import java.util.function.Function;

public class ExempleTYpeMethodReference {
    public static void main(String[] args) {

        Function<String, Integer> contarCaracteres = s -> s.length();

        System.out.println(contarCaracteres.apply("TesteMtDoido"));

        Function<String, Integer> contarCaracteresMR = String::length;
        System.out.println(contarCaracteresMR.apply("renato"));

        Function<Usuario, String> retornaLogin = u -> u.getLogin();

        Usuario usuario = new Usuario("Login", "senha");

        // CHAMANDO POR O METHOD FEITO POR LAMBDA
        System.out.println(retornaLogin.apply(usuario));

        Function<Usuario, String> retornaLogin2 = Usuario::getLogin;

        // CHAMANDO O METHOD FEITO FOR REFERENCIA
        System.out.println(retornaLogin2.apply(usuario));

    }
}
