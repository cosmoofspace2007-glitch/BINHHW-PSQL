package Baiseasion16;

public class Product1
{
    private String name;
    private double price;

    public  Product1(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Product1{" + "name=" + name + ", price=" + price + '}';
    }
}
