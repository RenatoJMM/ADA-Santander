package Lecture_6.SegundaParteAula;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseDeDados {

    List<Usuario> listUsuarios = new ArrayList<>();
    { // BLOCO DE INSTANCIA, ELE É INICIALIZADO APÓS DECLARAR AS VARIAVEIS DA CLASSE
        listUsuarios = List.of(new Usuario("login", "senha"), new Usuario("login2", "senha2"));
    }

    public Optional<Usuario> getByName(String name) {
        for (Usuario user : this.listUsuarios) {
            if (user.getLogin().equals(name)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}
