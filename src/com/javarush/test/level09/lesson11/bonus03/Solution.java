package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.*;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        SortedMap<String, Integer> sm = new TreeMap<>(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                if (isGreaterThan((String)o1, (String)o2)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        SortedMap<String, Integer> sm2 = new TreeMap<>(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                if (Integer.parseInt((String)o1) > Integer.parseInt((String)o2)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                sm2.put(array[i], i);
            } else {
                sm.put(array[i], i);
            }
        }
        Iterator<String> iterator = sm.keySet().iterator();
        Iterator<String> iterator2 = sm2.keySet().iterator();
        for (int i = 0; i < array.length; i++) {
            if (sm.containsValue(i)) {
                array[i] = iterator.next();
            } else {
                array[i] = iterator2.next();
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
