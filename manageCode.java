package Baiseasion5;

import java.util.Scanner;

public class manageCode
{
	public static void main(String[] args)
	{
        Scanner sc=new Scanner(System.in);
        String str = "";
        while(true)
        {
            System.out.println("********************** MENU **********************\n" +
                    "1.Nhập chuỗi\n" +
                    "2.Đếm số kí tự thường, hoa, số, đặc biệt\n" +
                    "3.Đảo ngược chuỗi\n" +
                    "4.Kiểm tra Palindrome\n" +
                    "5.Chuẩn hóa chuỗi(Xóa khoảng trắng dư thừa Viết hoa chữ cái đầu tiên của chuỗi, các ký tự khác giữ nguyên)\n" +
                    "6.Thoát\n");
            System.out.println("Nhập vào lựa chọn của bạn");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    System.out.println("Nhập vào chuỗi của bạn");
                    str = sc.nextLine();
                    break;

                case 2:
                    int lower = 0, upper = 0, digit = 0, special = 0;
                    for (int i = 0; i < str.length(); i++)
                    {
                        char c = str.charAt(i);

                        if (Character.isDigit(c)) {
                            digit++;
                        } else if (Character.isLowerCase(c)) {
                            lower++;
                        } else if (Character.isUpperCase(c)) {
                            upper++;
                        } else {
                            special++;
                        }
                    }
                    System.out.println("chữ thường" + lower);
                    System.out.println("chữ hoa" + upper);
                    System.out.println("chữ số" + digit);
                    System.out.println("kí tự đặc biệt" + special);
                    break;

                case 3:
                    String a = new StringBuilder(str).reverse().toString();
                    System.out.println("Chuỗi in ngược là:" + a);
                    break;

                case 4:
                    String clean = str.replace("//s+", "");
                    boolean  Palindrome= true;
                    for (int i = 0; i < str.length(); i++)
                    {
                        if(clean.charAt(i) != clean.charAt(str.length()- 1 - i))
                        {
                            Palindrome = false;
                            System.out.println("Đây ko là chuỗi Palindrome");
                            break;
                        }
                        else
                        {
                            System.out.println("Đây là chuỗi Palindrome");
                            break;
                        }
                    }

                case 5:
                    String de = str.trim().replaceAll("//s+", "");
                    String[] words = de.split(" ");
                    String result = "";

                    for(int i = 0; i < words.length; i++)
                    {
                        String w =  words[i];
                        result += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase();
                    }
                    System.out.println(result);
                    break;

                case 6:
                    System.out.println("Đã thoát chương trình");
                    break;
            }
        }

    }
}
