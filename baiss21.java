import java.util.Scanner;
public class baiss21 { //Tính tổng các số từ 1 đến N
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên N: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("ko hợp lệ");
        } else if (n < 0) {
            System.out.println("ko hợp lệ");

        } else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum = sum + i;
            }System.out.printf(" Tổng của %d: %d",n,sum);
        }

    }

}
