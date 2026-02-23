package Baiseasion13;

public class Invoice
{
    private int id;
    private double amount;
    private String descrip;

    public  Invoice(int id, double amount, String descrip)
    {
        this.id = id;
        this.amount = amount;
        this.descrip = descrip;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getDescrip()
    {
        return descrip;
    }

    public void setDescrip(String descrip)
    {
        this.descrip = descrip;
    }

    @Override
    public String toString()
    {
        return "Invoice{" + "id=" + id + ", amount=" + amount + '}' + descrip;
    }
}
