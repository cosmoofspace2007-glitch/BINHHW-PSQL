package Baiseasion5;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailCheck
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi của bạn: ");
        String email = sc.nextLine();
        Pattern check = Pattern.compile("^[\\w-.]+@[\\w-]+\\.[a-z]{2,3}$");
        Matcher mat = check.matcher(email);
        Boolean a = mat.matches();
        if (a == true)
        {
            System.out.println("email hợp lệ");
        }
        else
        {
            System.out.println("email ko hợp lệ");
        }

    }
}
