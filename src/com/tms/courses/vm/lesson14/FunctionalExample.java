package com.tms.courses.vm.lesson14;

@FunctionalInterface
public interface FunctionalExample<T>
{
    T execute(T value);
}
