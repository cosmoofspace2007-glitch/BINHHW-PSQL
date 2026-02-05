package Baiseasion4;

import java.util.Scanner;

public class Selection {
    static void selectionSort(int[] mang)
    {
          int a = mang.length;
         for(int i = 0; i < a - 1; i++)
         {
             int min = i;
             for(int j = i + 1; j < a; j++)
             {
                 if(mang[j] > mang[min])
                 {
                     min = j;
                 }
             }
             int temp = mang[min];
             mang[min] = mang[i];
             mang[i] = temp;
         }
    }

    public static int sequentialSearch(int[] mang,int key)
    {
        for(int i = 0; i < mang.length; i++)
        {
            if(mang[i] == key)
            {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] mang,int key2)
    {
        int left = 0, right = mang.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(key2 == mang[mid])
            {
                return mid;
            }
            if(mang[mid] < key2)
            {
                right = mid + 1;
            }
            else
            {
                left = mid - 1;
            }
        }
        return -1;
    }


        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập vào kích thước của mảng: ");
            int m = sc.nextInt();
            int[] mang = new int[m];

            for (int i = 0; i < mang.length; i++)
            {
                mang[i] = sc.nextInt();
                System.out.printf("Phần tử %d là: %d\n", i, mang[i]);
            }
            selectionSort(mang);
            System.out.println("Mảng sau khi đã sắp xếp là: ");
            for (int num : mang)
            {
                System.out.print(num + " ");
            }

            System.out.println("Nhập số bạn muốn tìm.");
            int key = sc.nextInt();
            int index = sequentialSearch(mang, key);
            System.out.println("Vị trí số cần tìm theo tìm kiếm tuyến tính là: " + index);

            System.out.println("Nhập số bạn muốn tìm.");
            int key2 = sc.nextInt();
            int index2 = binarySearch(mang, key2);
            System.out.println("Vị tí số cần tìm theo tìm kiếm nhị phân là: " + index2);
        }
    }
