package Baiseasion10;

public class Shape
{
    public double Area()
    {
        return 0;
    }
}

class Rectangle extends Shape
{
    double width;
    double height;
    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    @Override
    public double Area()
        {
        return width * height;
        }

}

class Circle extends Shape
{
    double radius;
    public Circle(double radius)
    {
        this.radius = radius;
    }
    @Override
    public double Area()
        {
        return Math.PI * radius * radius;
        }
}