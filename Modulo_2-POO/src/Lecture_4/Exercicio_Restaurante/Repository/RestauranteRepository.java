package Lecture_4.Exercicio_Restaurante.Repository;

import java.util.ArrayList;
import java.util.List;

import Lecture_4.Exercicio_Restaurante.Domain.Restaurante;

public class RestauranteRepository {

    private List<Restaurante> listaRestaurantes;

    public RestauranteRepository() {
        this.listaRestaurantes = new ArrayList<Restaurante>();
    }

    public void addRestaurante(Restaurante restaurante) {
        this.listaRestaurantes.add(restaurante);
    }

    @Override
    public String toString() {
        String retorno = "";

        if (this.listaRestaurantes.isEmpty()) {
            retorno = "Nenhum Restaurante cadastrado!";
        } else {
            for (int i = 0; i < this.listaRestaurantes.size(); i++) {
                retorno += "\n" + (i + 1) + "-" + this.listaRestaurantes.get(i).toString();
            }
        }

        return retorno;
    }

    public List<Restaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

}
