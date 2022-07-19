package com.tms.courses.vm.lesson15;

import com.tms.courses.vm.lesson13.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Sasha", 2));
        students.add(new Student("Lesha", 5));
        students.add(new Student("Pasha", 8));

        System.out.println(students);

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getMark() > 4)
                .collect(Collectors.toList());

        System.out.println(filteredStudents);
    }
}
