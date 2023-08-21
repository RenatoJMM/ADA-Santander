package Lecture_6.impl;

public class StringArrayLista extends ArrayLista {

    public void add(String str) {
        super.add(str);
    }

    @Override
    public String get(int index) {
        return (String) super.get(index);
    }

}
