package com.tms.courses.vm.lesson17;

public class Document
{
    private String phone;
    private String email;

    public Document()
    {
    }

    public Document(String phone, String email)
    {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Document{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
