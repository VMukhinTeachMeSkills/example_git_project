package com.tms.courses.vm.lesson13;

import java.util.Objects;

public class Student
{
    private String name;
    private float mark;
    private String group;

    public Student()
    {
    }

    public Student(String name, float mark)
    {
        this.name = name;
        this.mark = mark;
    }

    public Student(String name, float mark, String group)
    {
        this.name = name;
        this.mark = mark;
        this.group = group;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getMark()
    {
        return mark;
    }

    public void setMark(float mark)
    {
        this.mark = mark;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Float.compare(student.mark, mark) == 0 && Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, mark, group);
    }
}
