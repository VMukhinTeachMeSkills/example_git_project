package com.tms.courses.vm.lesson15;

import com.tms.courses.vm.lesson13.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskExample
{
    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Pasha", 5, "1"));
        students.add(new Student("Pasha", 5, "1"));
        students.add(new Student("Sasha", 8, "2"));
        students.add(new Student("Lesha", 3, "1"));
        students.add(new Student("Ignat", 6, "2"));
        students.add(new Student("Vanya", 8, "1"));

        System.out.println(students);

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getMark() > 4)
                .peek(student ->
                {
                    if (student.getGroup().equals("1"))
                    {
                        float mark = student.getMark();
                        student.setMark(mark + 1);
                    }
                })
                .sorted(Comparator.comparing(Student::getMark).reversed())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(filteredStudents);
    }
}
