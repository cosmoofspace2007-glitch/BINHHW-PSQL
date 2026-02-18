package Baiseasion5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passCheck {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào mật khẩu của bạn");;
        String pass = sc.nextLine();
        int lenght = pass.length();
        if (lenght != 8)
        {
            System.out.println("Mật khẩu ko hợp lệ");
        }
        else
        {
            Pattern check = Pattern.compile("^[A-Z]+[a-z]+\\d+[@#$!%]$");
            Matcher mat = check.matcher(pass);
            Boolean a = mat.matches();
            if(a == true)
            {
                System.out.println("Mật khẩu hợp lệ");
            }
            else
            {
                System.out.println("Mậ khẩu ko hợp lệ");
            }
        }

    }
}
