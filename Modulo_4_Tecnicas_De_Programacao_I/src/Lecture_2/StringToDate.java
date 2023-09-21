package Lecture_2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringToDate {

    public static void main(String[] args) {

        String dateString = "2023-08-09";
        String dateHourStr = "2023-08-09 14:05:30";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDate localDate = LocalDate.parse(dateString, formatter);
        LocalDateTime localDateTime = LocalDateTime.parse(dateHourStr, formatter2);

        System.out.println(localDate);
        System.out.println(localDateTime);

        LocalDate today = LocalDate.now();
        LocalTime nowVar = LocalTime.now();

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("hh:mm:ss a");

        System.out.println(today.format(formatter3));
        System.out.println(nowVar.format(formatter4));

    }

}
