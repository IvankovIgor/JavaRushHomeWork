package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("YANUARY 5 2000"));
    }

    public static boolean isDateOdd(String date)
    {
        Date firstDay = new Date(date);
        Date curDate = new Date(date);
        firstDay.setHours(0);
        firstDay.setMinutes(0);
        firstDay.setMonth(0);
        firstDay.setSeconds(0);
        firstDay.setDate(1);
        long msCur = curDate.getTime() - firstDay.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        long days = msCur/msDay;
        long day = days + 1;
//        System.out.println(firstDay.toString());
//        Date curDate = new Date(date);
        return day % 2 != 0;
    }
}
