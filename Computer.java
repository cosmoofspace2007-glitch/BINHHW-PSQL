package Baiseasion10;

public class Computer
{
    public double calculatePrice(double basePrice)
    {
        return basePrice;
    }

    public double calculatePrice(double baseVolume, double tax)
    {
      return baseVolume * tax;
    }

    public double calculatePrice(double basePrice, double tax, double discount)
    {
      return basePrice * tax * discount;
    }
}
