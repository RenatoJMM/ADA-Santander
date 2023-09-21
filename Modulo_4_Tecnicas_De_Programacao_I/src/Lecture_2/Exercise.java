package Lecture_2;

import java.time.LocalDate;

public class Exercise {
    public static void main(String[] args) {

        LocalDate fisrtVacine = LocalDate.of(2023, 07, 01);

        System.out.println("Dose 1:" + fisrtVacine);
        System.out.println("Dose 2:" + fisrtVacine.plusMonths(1));
        System.out.println("Dose 3:" + fisrtVacine.plusMonths(2));

    }

}
