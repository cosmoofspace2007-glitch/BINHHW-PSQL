package Baiseasion11;

import java.util.Scanner;

public abstract class Employee
{
    int id;
    String name;

    public Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    abstract double calculateSalary();
    void showInfo()
        {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        }
}




interface BonusEligible
{
    double calculateBonus();
}




class FullTimeEmployee extends Employee
{
    public  FullTimeEmployee(int id, String name)
    {
        super(id, name);
    }

    @Override
    double calculateSalary()
    {
        return 5000;
    }
}

class PartTimeEmployee extends Employee implements BonusEligible
{
    int workingHour;

    public  PartTimeEmployee(int id, String name, int workingHour)
    {
        super(id, name);
        this.workingHour = workingHour;
    }

    @Override
    double calculateSalary()
    {
        return 5000 * workingHour;
    }

    @Override
    public double calculateBonus()
    {
        return 5000;
    }
}
