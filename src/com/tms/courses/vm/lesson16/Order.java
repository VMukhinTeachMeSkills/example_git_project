package com.tms.courses.vm.lesson16;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order
{
    private String id;
    private Map<Product, Integer> entries;
    private Date date;
    private User user;

    public Order()
    {
        entries = new HashMap<>();
    }

    public Order(String id, Map<Product, Integer> entries, Date date, User user)
    {
        this.id = id;
        this.entries = entries;
        this.date = date;
        this.user = user;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Map<Product, Integer> getEntries()
    {
        return entries;
    }

    public void setEntries(Map<Product, Integer> entries)
    {
        this.entries = entries;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "id='" + id + '\'' +
                ", entries=" + entries +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
