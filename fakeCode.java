package Baiseasion5;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class fakeCode {
    public  static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập vào số nguyên của bạn");
        int n=sc.nextInt();

        String chart = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random rnd=new Random();
        StringBuilder result=new StringBuilder(n);

        for(int i=0;i<n;i++)
        {
            int index=rnd.nextInt(chart.length());
            result.append(chart.charAt(index));
        }
        System.out.println(result);
    }
}
