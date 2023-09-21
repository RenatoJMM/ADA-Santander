package Lecture_1;

import java.time.LocalTime;
import java.time.Month;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MomentosEspeciais {

    public static LocalDate evento1() {
        return LocalDate.of(1998, 07, 25);
    }

    public static LocalTime evento2() {
        return LocalTime.of(11, 42);
    }

    public static LocalDateTime evento3() {
        return LocalDateTime.of(2023, Month.AUGUST, 23, 13, 45, 40);
    }

}
