import java.math.BigDecimal;
import java.util.Scanner;
public class Baiss1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào bán kính"); //  Tính diện tích hình tròn
        double bankinh = sc.nextDouble();
        double so_pi = 3.14;

        double dien_hinh_tron = bankinh * bankinh * so_pi;
        System.out.println(dien_hinh_tron);


        System.out.println("Nhâp số đầu tiên"); // Toán tử số học
        int a = sc.nextInt();
        System.out.println("Nhập vào số thứ hai");
        int b = sc.nextInt();
        System.out.println("Tổng" + (a + b));
        System.out.println("Hiệu" + (a - b));
        System.out.println("Tích" + (a * b));
        System.out.println("Thương" + (a / b));
        System.out.println("Tổng" + (a % b));

        System.out.println("Nhập vào tử số: "); // Tính tổng hai phân số
        int n = sc.nextInt();
        System.out.println("Nhập vào mẫu số: ");
        int m = sc.nextInt();
        System.out.println("Nhập vào tử số2: ");
        int c = sc.nextInt();
        System.out.println("Nhập vào mẫu số2: ");
        int d = sc.nextInt();
        System.out.println("Tổng phân số");

        System.out.println("Nhập vào chiều rộng: "); // Tính diện tích và chu vi của hình chữ nhật
        float width = sc.nextFloat();
        System.out.println("Nhập vào chiều cao: ");
        float height = sc.nextFloat();
        System.out.println("Diện tích: ");
        double area = width * height;
        System.out.println("Chu vi: ");
        double perimeter = (width + height) * 2;
        System.out.println(area);
        System.out.println(perimeter);

        System.out.println("Cân nặng: "); // Tính toán chỉ số BMI
        int x = sc.nextInt();
        System.out.println("Chiều cao: ");
        double y = sc.nextDouble();
        double BMI = x / Math.sqrt(y);
        System.out.println("BMI: " + BMI);

        System.out.println("Vận tốc: "); // Tính quãng đường đi được
        int v = sc.nextInt();
        System.out.println("Thời gian: ");
        double h = sc.nextDouble();
        double qu_du = v * h;
        System.out.println("Quãng đường: " + qu_du);
    }
}


