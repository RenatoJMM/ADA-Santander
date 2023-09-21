package Lecture_2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DataManipulation {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println(nextWeek);

        LocalDate nextMonth = today.plusMonths(1);
        System.out.println(nextMonth);

        LocalDate nextYear = today.plusYears(1);
        System.out.println(nextYear);

        LocalDateTime todayHour = LocalDateTime.now();
        System.out.println(todayHour);

        System.out.println("Minus one hour: " + todayHour.minusHours(1));
        System.out.println("MInus two day: " + todayHour.minusDays(2));

        System.out.println("MInus two day and one hour: " + todayHour.minusDays(2).minusHours(1));

        // PERIOD

        Period periodOneYearThreeMonths = Period.of(1, 3, 0);
        System.out.println(periodOneYearThreeMonths);

        System.out.println("Plus a period: " + today.plus(periodOneYearThreeMonths));
        System.out.println("minus a period: " + today.minus(periodOneYearThreeMonths));
    }

}
