package Lecture_6.SegundaParteAula;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        BaseDeDados bd = new BaseDeDados();
        Optional<Usuario> usuarioBuscado = bd.getByName("login2");

        // imprimirUsuario(usuarioBuscado);



        // SEGUNDO TIPO DE VERIFICAÇÃO COM OPTIONAL

        // usuarioBuscado.ifPresentOrElse(usuario -> imprimirUsuario(usuario),
        // () -> System.out.println("User n encontrado"));
        // ;



        // TERCEIRO TIPO DE VERIFICAÇÃO COM OPTIONAL

        // Usuario user = usuarioBuscado.orElseThrow(() -> new RuntimeException("Usuário
        // não encontrado."));
        // imprimirUsuario(user);



        // CONSEGUIMOS USAR ALGUMAS FUNÇÕES (TIPO STREAM) NO OPTIONAL

        // String login = usuarioBuscado.filter(user -> user.getSenha().length() >
        // 3).map(user -> user.getLogin()).get();

        String login2 = usuarioBuscado.filter(user -> user.getSenha().length() > 3).map(user -> user.getLogin())
                .orElse("Senha inválida");
        // System.out.println(login);
        System.out.println(login2);

    }

    public static void imprimirUsuario(Usuario user) {

        // PRIMEIRO TIPO DE VERIFICAÇÃO DE OPTIONAL
        // if (user.isPresent()) {
        // System.out.println(user.get().getLogin());
        // } else {
        // System.out.println("Usuário não Encontrado!");
        // }

        System.out.println(user.getLogin());
    }

}
