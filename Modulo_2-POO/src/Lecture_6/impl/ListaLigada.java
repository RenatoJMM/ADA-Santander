package Lecture_6.impl;

import Lecture_6.contrato.Lista;

public class ListaLigada extends Lista {

    private int size;
    private Elemento primeiro;
    private Elemento ultimo;

    @Override
    public void add(Object obj) {

        Elemento primeiro = new Elemento(obj);
        if (size == 0) {
            this.primeiro = primeiro;
            this.ultimo = primeiro;
            size++;
        } else {
            Elemento novoElemento = new Elemento(obj);
            this.primeiro.setProximo(novoElemento);

            this.ultimo = novoElemento;
            size++;
        }
    }

    @Override
    public Object get(int index) {
        Elemento elemento = this.primeiro;
        for (int i = 0; i < index; i++) {
            elemento = elemento.getProximo();
        }
        return elemento.getObj();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            this.primeiro = this.primeiro.getProximo();
            this.size--;
            return;
        }

        Elemento elemento = this.primeiro;
        for (int i = 0; i < index - 1; i++) {
            elemento = elemento.getProximo();
        }
        elemento.setProximo(elemento.getProximo().getProximo());
        this.size--;
    }

    class Elemento {
        private Object obj;
        private Elemento proximo;

        public Elemento(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return this.obj;
        }

        public Elemento getProximo() {
            return this.proximo;
        }

        public void setProximo(Elemento proximo) {
            this.proximo = proximo;
        }
    }

}
