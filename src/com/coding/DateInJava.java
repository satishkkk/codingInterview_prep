package com.coding;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateInJava {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

    }
}
