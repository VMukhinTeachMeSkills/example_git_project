package com.tms.courses.vm.lesson14;

import com.tms.courses.vm.lesson13.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        task3();
    }

    public static void task3()
    {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();

        if (i == 1) {
            FunctionalExample<String> functionalExampleInterface;
            functionalExampleInterface = (String value) ->
            {
                StringBuilder sb = new StringBuilder(value);
                sb.reverse();
                return sb.toString();
            };
            System.out.println(functionalExampleInterface.execute("12345"));
        }
        else if (i == 2) {
            FunctionalExample<Integer> functionalExampleInterface;
            functionalExampleInterface = (Integer value) ->
            {
                int result = 1;
                for (int j = 1; j <= value; j++)
                {
                    result *= j;
                }
                return result;
            };
            System.out.println(functionalExampleInterface.execute(5));
        }
    }


}
