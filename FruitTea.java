package Baiseasion12;

public class FruitTea extends Drink
{
    FruitTea(int id,String name,double price)
    {
        super(id,name,price);
    }

    @Override
    public void prepare()
    {
        System.out.println("Lắc với đá và trái cây tươi");
    }
}
