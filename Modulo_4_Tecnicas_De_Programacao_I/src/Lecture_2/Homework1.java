package Lecture_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Homework1 {

    public static void main(String[] args) {
        List<String> datasStrings = new ArrayList<>();
        datasStrings.add("2023-08-10");
        datasStrings.add("2022-05-20");
        datasStrings.add("2021-11-30");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<LocalDate> listDates = new ArrayList<LocalDate>();

        for (String str : datasStrings) {
            LocalDate aux = LocalDate.parse(str, formatter);
            listDates.add(aux);
        }

        for (int i = 0; i < listDates.size(); i++) {
            System.out.println(listDates.get(i));
        }

    }

}
