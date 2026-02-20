package Baiseasion11;

public abstract class Payment
{
    double amount;

    public Payment(double amount)
    {
        this.amount=amount;
    }

    abstract void pay();

    void printAmount()
        {
        System.out.printf("%.2f",amount);
        }
}




interface Refundable
{
    void refund();
}




class CashPayment extends Payment
{
    public CashPayment(double amount)
    {
        super(amount);
    }

    @Override
    void pay()
    {
        System.out.println("Thanh toán bằng tiền mặt" + amount);
    }
}



class CreditCardPayment  extends Payment implements Refundable
{
    public CreditCardPayment(double amount)
    {
        super(amount);
    }

    @Override
    void  pay()
    {
        System.out.println("Thanh toán bằng thẻ tín dụng" + amount);
    }

    @Override
    public void refund()
        {
        System.out.println("Hoàn tiền qua thẻ tín dụng" + amount);
        }
}

class EWalletPayment   extends Payment implements Refundable
{
    public EWalletPayment(double amount)
    {
        super(amount);
    }
    @Override
    void  pay()
    {
        System.out.println("Thanh toán qua ví điện tử" + amount);
    }
    @Override
    public void refund()
        {
        System.out.println("Hoàn tiền qua ví điện tử" + amount);
        }

}



