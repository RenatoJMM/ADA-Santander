package Lecture_6;

public class ExemploConstructorMethodReference {

    public static void main(String[] args) {
        String login = "";
        String senha = "";

        // PARENTESES VAZIOS PQ NÃO RECEBE NADA
        BaseDeDados baseDeDados = () -> new Usuario();

        Usuario usuario1 = baseDeDados.getUsuario();
        System.out.println(usuario1);

        BaseDeDados baseDeDadosMethodReference = Usuario::new;
        System.out.println(baseDeDadosMethodReference.getUsuario());

        // DENTRO DO PARENTESES OS DOIS ARGUMENTOS QUE PRECISAM
        BaseDeDadosSegundoConst bDS = (l, s) -> new Usuario(l, s);

        BaseDeDadosSegundoConst bDSMR = Usuario::new;
        System.out.println(bDSMR.getUsuario(login, senha));

    }

}
