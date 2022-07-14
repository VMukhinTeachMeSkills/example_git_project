package com.tms.courses.vm.lesson14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class MainTask2
{
    public static void main(String[] args) throws ParseException
    {
        Scanner sc = new Scanner(System.in);
        String dateString = sc.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date date = formatter.parse(dateString);

        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        System.out.println(localDate.getDayOfWeek().toString());
    }
}
