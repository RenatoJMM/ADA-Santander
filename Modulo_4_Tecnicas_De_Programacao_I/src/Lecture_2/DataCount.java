package Lecture_2;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DataCount {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        LocalDate ontem = LocalDate.of(2023, Month.SEPTEMBER, 17);

        long diff = ChronoUnit.DAYS.between(ontem, hoje);

        System.out.println(diff);
    }

}
