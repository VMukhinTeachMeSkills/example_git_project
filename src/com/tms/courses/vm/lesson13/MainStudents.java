package com.tms.courses.vm.lesson13;

import java.util.ArrayList;
import java.util.List;

public class MainStudents
{
    public static void main(String[] args)
    {
        Student student1 = new Student("Slava", 8f);
        Student student2 = new Student("Pasha", 3f);
        Student student3 = new Student("Ivan", 2f);
        Student student4 = new Student("Sasha", 10f);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println(students);

        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getMark() < 4f)
            {
                students.remove(students.get(i));
                i--;
            }
        }

        System.out.println(students);
    }
}
