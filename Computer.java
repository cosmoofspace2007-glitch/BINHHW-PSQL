package Baiseasion12;

public class Computer extends Asset
{
    private int ram;
    private String cpu;

    public Computer(String assetCode, String name, double purchasePrice, int ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.8;
    }

    @Override
    public String toString() {
        return "Computer | Code: " + assetCode +
                " | Name: " + name +
                " | Price: " + purchasePrice +
                " | RAM: " + ram +
                " | CPU: " + cpu +
                " | Value: " + getMarketValue();
    }

}
