package Baiseasion11;

public abstract class Device
{
    int id;
    String name;

    public  Device(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    abstract void turnOn();
    abstract void turnOff();
}




interface Connectable
{
    void connectWifi();
}

interface Chargeable
{
    void charge();
}



class SmartPhone extends Device implements Connectable, Chargeable
{
    public SmartPhone(int id, String name)
    {
        super(id, name);
    }

    @Override
    void turnOff()
    {
        System.out.println("Device is turned off");
    }

    @Override
    void turnOn()
    {
        System.out.println("Device is turned on");
    }

    @Override
    public void connectWifi()
    {
        System.out.println("SmartPhone is connected to wifi");
    }

    @Override
    public void charge()
    {
        System.out.println("SmartPhone is chargerble");
    }
}


class Laptop extends Device implements Connectable, Chargeable
{
    public Laptop(int id, String name)
    {
        super(id, name);
    }

    @Override
    void turnOff()
    {
        System.out.println("Device is turned off");
    }

    @Override
    void turnOn()
    {
        System.out.println("Device is turned on");
    }

    @Override
    public void charge()
    {
        System.out.println("Laptop is chargerble");
    }

    @Override
    public void connectWifi()
    {
        System.out.println("Laptop is connected to wifi");
    }
}


class Television  extends Device implements Connectable
{
    public Television(int id, String name)
    {
        super(id, name);
    }

    @Override
    void turnOff()
    {
        System.out.println("Device is turned off");
    }

    @Override
    void turnOn()
    {
        System.out.println("Device is turned on");
    }

    @Override
    public void connectWifi()
    {
        System.out.println("Television is connected to wifi");
    }
}