import java.util.Scanner;
public class baiss24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào cạnh thứ 1");
        int a = sc.nextInt();
        System.out.println("Nhập vào cạnh thứ 2");
        int b = sc.nextInt();
        System.out.println("Nhập vào cạnh thứ 3");
        int c = sc.nextInt();
        if(a+b<c || a+c<b || b+c<a){
            System.out.println("Ba cạnh không tạo thành tam giác");
        }else if (a == b && b == c){
            System.out.println("Đây là tam giác đều");
        } else if (a == b || a==c || c==b){
            System.out.println("Đây là tam giác cân");
        } else if (a*a + b*b == c*c || a*a + c*c == b*b || c*c + b*b == a*a) {
            System.out.println("Đây là tam giác vuông");
        }else{
            System.out.println("Đây là tam giác thường");
        }
    }
}
