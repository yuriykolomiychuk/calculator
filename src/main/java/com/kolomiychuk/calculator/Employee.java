package com.kolomiychuk.calculator;

public class Employee
{

    int age;
    Object object = new Object();

    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true; //Reference equality.
        }
        if(!(obj instanceof Employee))
        {
            return false; // not the same type.
        }
        Employee other = (Employee) obj;
        return age == other.age;
    }

}