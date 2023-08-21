package Lecture_7;

import java.util.ArrayList;
import java.util.List;

public class MinhaPilha extends Pilha {

    private List<Object> lista;

    public MinhaPilha() {
        this.lista = new ArrayList<Object>();
    }

    @Override
    public void PUSH(Object obj) {
        this.lista.add(obj);

    }

    @Override
    public Object POP() {
        Object last = this.lista.get(this.lista.size() - 1);
        this.lista.remove(this.lista.size() - 1);
        return last;
    }

    @Override
    public Object PEEK() {
        return this.lista.get(this.lista.size() - 1);

    }

    @Override
    public String toString() {
        return this.lista.toString();
    }

}
