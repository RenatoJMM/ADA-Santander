package Lecture_4.Exercicio_Restaurante.Service;

import Lecture_4.Exercicio_Restaurante.Domain.Prato;
import Lecture_4.Exercicio_Restaurante.Repository.PratoRepository;

public class PratoService {

    private PratoRepository lista;

    public PratoService() {
        this.lista = new PratoRepository();
    }

    public Prato criarPrato(String nome, String descricao, double preco) {
        Prato prato = new Prato(nome, descricao, preco);

        this.lista.addPrato(prato);

        System.out.println("Prato criado com Sucesso!");

        return prato;
    }

    public Prato buscarPrato(int num) {
        num = num - 1;
        if (this.lista.getListaPratos().isEmpty()) {
            return null;
        } else {
            return this.lista.getListaPratos().get(num);
        }
    }

    public String listarPratos() {
        return this.lista.toString();
    }

    public PratoRepository getLista() {
        return lista;
    }

}
