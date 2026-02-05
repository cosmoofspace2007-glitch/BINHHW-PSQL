package Baiseasion4;

import java.util.Arrays;
import java.util.Scanner;
public class twoWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số hàng của mảng:");
        int n = sc.nextInt();
        System.out.println("Nhập sôa cột của mảng:");
        int m = sc.nextInt();

        int[][] da_Chieu = new int[n][m];
        System.out.println("Nhập các phần tử của mảng: ");

        int chan = 0;
        int le = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                da_Chieu[i][j] = sc.nextInt();
                System.out.printf("Phần tử %d,%d: %d", i, j, da_Chieu[i][j]);


            if(da_Chieu[i][j] % 2 == 0){
                  chan += da_Chieu[i][j];
            } else {
                  le += da_Chieu[i][j];
            }
                System.out.println("\nTổng số chẵn: " + chan);
                System.out.println("\nTổng số lẻ: " + le);
            }
        }
    }
}
