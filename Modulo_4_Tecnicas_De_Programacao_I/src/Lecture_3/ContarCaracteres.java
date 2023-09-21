package Lecture_3;

@FunctionalInterface
public interface ContarCaracteres<T, U> {

    public U execute(T palavra);
}
