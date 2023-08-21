package Lecture_6.impl;

import Lecture_6.contrato.Lista;

public class ArrayLista extends Lista {

    private int size;
    private Object[] array;

    public ArrayLista() {
        array = new Object[10];
    }

    @Override
    public void add(Object obj) {
        if (size == this.array.length) {
            resize();
        }

        this.array[size] = obj;
        this.size++;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    public void resize() {
        Object[] novoArray = new Object[this.array.length * 2];

        for (int i = 0; i < this.array.length; i++) {
            novoArray[i] = this.array[i];
        }
        this.array = novoArray;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.size - 1] = null;
        this.size--;
    }

}
