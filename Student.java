package Baiseasion8;

import java.util.Scanner;

public class Student
{
    int id;
    String name;
    int age;

    public  Student(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static  void main(String[] args)
    {
        Student s = new Student(001, "Nguyễn Văn C", 18);
        System.out.println("ID: " + s.id + ", Name: " + s.name + ", Age: " + s.age);
    }
}


