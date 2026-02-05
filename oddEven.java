package Baiseasion4;

import java.util.Scanner;

public class oddEven {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào kích thước của mảng");
        int m =  sc.nextInt();
        int[] day =  new int[m];

        int[] result = new int[m];
        int index = 0;

        if(m == 0)
        {
            System.out.println("Dãy ko có phần tử nào");
        }

        for(int i = 0; i < day.length; i++)
        {
            System.out.printf("Nhập vào phần tử %d: %d\n", i, day[i]);
            day[i] = sc.nextInt();
        }

        for(int i = 0; i < day.length; i++)
        {
            if(day[i] % 2 == 0)
            {
                result[index++] = day[i];
            }
        }

        for(int i = 0; i < day.length; i++)
        {
            if(day[i] % 2 != 0)
            {
                result[index++] = day[i];
            }
        }
        System.out.println("Mảng sau khi sắp xếp là");
        for(int i = 0; i < day.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}
