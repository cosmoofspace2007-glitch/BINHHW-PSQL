package Baiseasion8;

public class Rectangle
{
    double width;
    double height;

    public  Rectangle(double w, double h)
    {
        this.width = w;
        this.height = h;
    }

    public double getArea()
        {
        return width * height;
        }
    public double getPerimeter()
        {
        return 2 * (width + height);
        }
    public  double getVolume()
        {
        return width * height;
        }

    public  double getWidth()
        {
        return width;
        }
    public  double getHeight()
        {
        return height;
        }

    @Override
    public String toString()
    {
        return "width=" + width + ", height=" + height + ", area=" + getArea() + ", perimeter=" + getPerimeter();
    }

    public static void main(String[] args)
    {

        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(1.0, 1.9);
        Rectangle r3 = new Rectangle(45, 6);

        System.out.println("Rectangle 1: " + r1);
        System.out.println("Rectangle 2: " + r2);
        System.out.println("Rectangle 3: " + r3);

        Rectangle largest = r1;

        if (r2.getArea() > largest.getArea())
        {
            largest = r2;
        }
        if(r3.getArea() > largest.getArea())
        {
            largest = r3;
        }

        System.out.println("Largest area: " + largest.getArea() + '(' + largest.getWidth() + ',' + largest.getHeight() + ')');
    }
}

