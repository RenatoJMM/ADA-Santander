package Lecture_3;

//EVITA QUE SEJA CRIADO MAIS DE UM MÉTODO ABSTRATO
@FunctionalInterface
public interface Operacao {

    public Integer execute(Integer num1, Integer num2);

}
