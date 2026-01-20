import java.util.Scanner;
public class baiss31 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập tên bạn: ");
        String n=sc.nextLine();
        System.out.println(n);
        System.out.println("Nhập vào tên sp: ");
        String a=sc.nextLine();
        System.out.println(a);
        System.out.println("Nhập vào giá sản phẩm: ");
        double b=sc.nextDouble();
        System.out.println("Nhập vào số lượng sản phẩm: ");
        int c=sc.nextInt();
        System.out.println("Khách có thẻ thành viên ko: ");
        boolean d=sc.nextBoolean();
        System.out.println("Số tiền khi mua hàng: ");
        double mon = b * c;
        if(!d){
            System.out.println("ko được giảm");
        }else{
            System.out.println("được giảm 10%");
            System.out.println("số tiền khi mua hàng: ");
            double mon2 = mon - (mon * 10/100);
            System.out.println(mon2);
        }
        System.out.println("số tiền VAT là: ");
        double mon3 = (mon * 8/100);
        System.out.println(mon3);

        System.out.println("Tổng tiền là: ");
        double mon4 = mon + (mon * 8/100);
        System.out.println(mon4);

    }
}
