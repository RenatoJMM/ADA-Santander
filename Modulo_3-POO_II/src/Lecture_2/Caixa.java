package Lecture_2;

public class Caixa<T> {

    private T objeto;

    public Caixa(T objetoCaixa) {
        this.objeto = objetoCaixa;
    }

    public void abrirCaixa() {
        System.out.println("O que foi encontrado dentro da caixa: " + this.objeto);
    }
}
