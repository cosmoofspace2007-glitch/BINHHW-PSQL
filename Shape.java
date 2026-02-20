package Baiseasion11;

public abstract class Shape
{
    String name;

    public Shape(String name)
    {
        this.name=name;
    }

    abstract double getArea();
    abstract double getPerimeter();
    void displayInfo()
    {
        System.out.println("Shape Name: "+name);
    };
}




interface Drawable
{
    void draw();
}




class Circle extends Shape implements Drawable
{
    double radius;

    public Circle(String name, double radius)
    {
        super(name);
        this.radius=radius;
    }

    @Override
    double getArea()
    {
        return Math.PI * radius * radius;
    }
    @Override
    double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }
    @Override
    public void draw()
    {
        System.out.println("Drawing Circle");
    }
}


class Rectangle extends Shape  implements Drawable
{
    double width;
    double height;

    public Rectangle(String name, double width, double height)
    {
        super(name);
        this.width=width;
        this.height=height;
    }

    @Override
    double getArea()
    {
        return width * height;
    }
    @Override
    double getPerimeter()
    {
        return 2 * (width + height);
    }
    @Override
    public void draw()
        {
        System.out.println("Drawing Rectangle");
        }
}


