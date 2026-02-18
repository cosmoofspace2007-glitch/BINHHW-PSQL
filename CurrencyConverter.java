package Baiseasion8;
public class CurrencyConverter
{
    static double rate;
    public static double setRate(double r)
    {
        if (r <= 0)
        {
            System.out.println("Ko hợp lệ");
            return 0;
        }
        else
        {
            return rate = r;
        }
    }

    public static double getRate()
    {
       return rate;
    }

    public static double toUSA(int vnd)
    {
        if(rate == 0)
        {
            System.out.println("Chưa thiết lập tỉ giá ");
            return 0;
        }
        else
        {
            return (vnd/rate);
        }
    }

    public static void main(String[] args)
    {
        CurrencyConverter.setRate(25.000);

        int vnd = 450000;
        double usa = CurrencyConverter.toUSA(vnd);

        System.out.println("Tỉ giá hiện tại: " + CurrencyConverter.getRate());
        System.out.println("VND: " + vnd);
        System.out.println("USA: " + usa);
    }
}
