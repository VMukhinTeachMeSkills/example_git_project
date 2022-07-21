package com.tms.courses.vm.lesson16;

import java.util.ArrayList;
import java.util.List;

public class Store
{
    private List<Order> orders;

    public Store()
    {
        orders = new ArrayList<>();
    }

    public Store(List<Order> orders)
    {
        this.orders = orders;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

    @Override
    public String toString()
    {
        return "Store{" +
                "orders=" + orders +
                '}';
    }
}
