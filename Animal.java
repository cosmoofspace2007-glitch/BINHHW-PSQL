package Baiseasion10;

public class Animal
{
   protected String name;

   public void makeSound()
    {
        System.out.println("Some animal sound");
    }
}

class Dog extends Animal
{
    public Dog(String name)
    {
        this.name = name;
    }
}

