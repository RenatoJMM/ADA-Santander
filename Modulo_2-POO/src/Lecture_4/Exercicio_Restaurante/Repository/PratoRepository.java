package Lecture_4.Exercicio_Restaurante.Repository;

import java.util.ArrayList;
import java.util.List;

import Lecture_4.Exercicio_Restaurante.Domain.Prato;

public class PratoRepository {

    private List<Prato> listaPratos;

    public PratoRepository() {
        this.listaPratos = new ArrayList<Prato>();
    }

    public void addPrato(Prato prato) {
        listaPratos.add(prato);
    }

    @Override
    public String toString() {
        String retorno = "";

        if (listaPratos.isEmpty()) {
            retorno = "Nenhum Prato cadastrado!";
        } else {
            for (int i = 0; i < listaPratos.size(); i++) {
                retorno += "\n" + (i + 1) + "-" + listaPratos.get(i).toString();
            }
        }
        return retorno;
    }

    public List<Prato> getListaPratos() {
        return listaPratos;
    }

}
