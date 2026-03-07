package Baiseasion12;

public abstract class Drink implements IPromotion {

    protected int id;
    protected String name;
    protected double price;

    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract void prepare();

    public void applyDiscount(double percentage) {
        price = price - price * percentage / 100;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Price: " + price);
    }
}
