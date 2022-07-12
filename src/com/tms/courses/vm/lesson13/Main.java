package com.tms.courses.vm.lesson13;

import java.util.*;

public class Main
{
    private static final Map<Integer, String> MONTH;

    static {
        MONTH = new HashMap<>();
        MONTH.put(1, "JANUARY");
        MONTH.put(2, "FEBRUARY");
        MONTH.put(3, "MARCH");
        MONTH.put(4, "APRIL");
        MONTH.put(5, "MAY");
        MONTH.put(6, "JUNE");
        MONTH.put(7, "JULY");
        MONTH.put(8, "AUGUST");
        MONTH.put(9, "SEPTEMBER");
        MONTH.put(10, "OCTOBER");
        MONTH.put(11, "NOVEMBER");
        MONTH.put(12, "DECEMBER");
    }

    public static void main(String[] args)
    {
        Integer[] array = {1, 2, 3, 4, 5, 1, 2, 13, 14};
        List<Integer> list = Arrays.asList(array);

        Set<Integer> set = convertListToSet(list);

        System.out.println(set);

        System.out.println(getMonth(1));
        System.out.println(getMonth(6));
        System.out.println(getMonth(100));
        System.out.println(getMonth(7));
        System.out.println(getMonth(-1));
    }

    public static Set<Integer> convertListToSet(List<Integer> list)
    {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < list.size(); i++)
        {
            Integer currentElement = list.get(i);

            if (!result.contains(currentElement))
            {
                result.add(currentElement);
            }
        }

        return result;
    }

    public static String getMonth(Integer monthNumber) {
        if (MONTH.containsKey(monthNumber)) {
            return MONTH.get(monthNumber);
        }
        return "Incorrect month number";
    }
}
