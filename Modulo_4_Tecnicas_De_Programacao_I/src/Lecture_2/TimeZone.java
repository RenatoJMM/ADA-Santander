package Lecture_2;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZone {

    public static void main(String[] args) {

        // PRINT ALL THE TIME ZONES AVAILABLE

        // for (String zoneId : ZoneId.getAvailableZoneIds()) {
        // System.out.println(zoneId);
        // }

        System.out.println(ZoneId.getAvailableZoneIds().size());

        ZonedDateTime dateHourNowTimeZoned = ZonedDateTime.now();
        System.out.println(dateHourNowTimeZoned);

        ZonedDateTime dateHourParis = dateHourNowTimeZoned.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        System.out.println(dateHourParis);

    }

}
