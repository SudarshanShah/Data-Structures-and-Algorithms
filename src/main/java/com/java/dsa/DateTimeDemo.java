package com.java.dsa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();
        System.out.println(dtf.format(localDate));

        LocalDate localDate1 = localDate.plusDays(7);

        System.out.println(dtf.format(localDate1));

        String format = dtf.format(localDate1);
        System.out.println(format);
    }
}
