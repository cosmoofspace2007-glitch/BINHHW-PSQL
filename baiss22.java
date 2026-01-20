import java.util.Scanner;
public class baiss22 { //Tìm số ngày trong tháng
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên từ 1 đến 12: ");
        int a = sc.nextInt();
        switch (a){
            case 1:
                System.out.println("tháng này có 31 ngày");
                break;
            case 2:
                System.out.println("tháng này có 28 hoặc 29 ngày");
                break;
            case 3:
                System.out.println("tháng này có 31 ngày");
                break;
            case 4:
                System.out.println("tháng này có 30 ngày");
                break;
            case 5:
                System.out.println("tháng này có 31 ngày");
                break;
            case 6:
                System.out.println("tháng này có 30 ngày");
                break;
            case 7:
                System.out.println("tháng này có 31 ngày");
                break;
            case 8:
                System.out.println("tháng này có 31 ngày");
                break;
            case 9:
                System.out.println("tháng này có 30 ngày");
                break;
            case 10:
                System.out.println("tháng này có 31 ngày");
                break;
            case 11:
                System.out.println("tháng này có 30 ngày");
                break;
            case 12:
                System.out.println("tháng này có 31 ngày");
        }
    }
}

