import java.util.Scanner;
public class baiss25 {
    static String readDigit(int n){
        switch (n){
            case 1:return "một";
            case 2:return "hai";
            case 3:return "ba";
            case 4:return "bốn";
            case 5:return "năm";
            case 6:return "sáu";
            case 7:return "bảy";
            case 8:return "tám";
            case 9:return "chín";
            default: return "";
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        if(100 > n || n > 999 ){
            System.out.println("Nhập số có 3 chữ số");
        }
            int hundreds = n / 100;
            int tens = (n % 100) / 10;
            int units = n % 10;

            String s = " ";

            s += readDigit(hundreds) + "trăm";

            if(tens ==  0 && units != 0){
                s += "lẻ";
            } else if(tens ==  1 && units == 0){
                s += "mười";
            } else if(tens > 1){
                s += " " + readDigit(tens) + "mươi";
            }

            if(tens !=  0 && units == 5 ){
                s += " lăm";
            }else{
                s += " " + readDigit(units);
            }
        System.out.println(s.trim());
            {

            }
        }
    }

