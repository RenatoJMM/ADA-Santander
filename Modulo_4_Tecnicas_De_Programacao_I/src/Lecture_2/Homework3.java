package Lecture_2;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Homework3 {

    public static void main(String[] args) {

        // PRINT ALL THE TIME ZONES AVAILABLE

        // for (String zoneId : ZoneId.getAvailableZoneIds()) {
        // System.out.println(zoneId);
        // }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");

        ZonedDateTime dateToday = ZonedDateTime.now();
        System.out.println("Today: " + dateToday.format(formatter));

        ZonedDateTime dateHourParis = dateToday.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        System.out.println("Paris: " + dateHourParis.format(formatter));

        ZonedDateTime dateHourNY = dateToday.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("New York: " + dateHourNY.format(formatter));

        ZonedDateTime dateHourTokyo = dateToday.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Tokyo: " + dateHourTokyo.format(formatter));

    }

}
