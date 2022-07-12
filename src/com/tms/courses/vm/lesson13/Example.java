package com.tms.courses.vm.lesson13;

public class Example<T, U>
{
    private T number;
    private U field;

    public Example()
    {
    }

    public Example(T number, U field)
    {
        this.number = number;
        this.field = field;
    }

    public T getNumber()
    {
        return number;
    }

    public void setNumber(T number)
    {
        this.number = number;
    }
}
