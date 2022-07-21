package com.tms.courses.vm.lesson16;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(560);
        numbers.add(2);
        numbers.add(5);
        numbers.add(8);
        numbers.add(0);

        Optional<Map.Entry<Integer, Long>> max = numbers.stream()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue));
        System.out.println(max);
    }
}
