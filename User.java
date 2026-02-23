package Baiseasion13;

import javax.lang.model.element.Element;
import java.util.LinkedList;
import java.util.Scanner;

public class User
{
    String name;
    String email;
    String number;

    public User(String name, String email, String number)
    {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getEmail()
    {
        return email;
    }

   @Override
   public String toString()
   {
       return "Tên: " + name +
              "Email: " + email +
              "Number: " + number;
   }
}

