package Baiseasion4;

import java.util.Scanner;

public class Bubble {
    static void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Nhập vào các phần tử của mảng:");
        for (int i = 0; i < n; i++) {

            System.out.printf("Phần tử thứ %d: %d\n", i, nums[i] = sc.nextInt());
        }
        bubbleSort(nums);
        System.out.println("\nMảng sau khi sắp xếp giảm dần là:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}