package Baiseasion6;
import java.util.Scanner;
public class User
{

        static Scanner sc = new Scanner(System.in);

        static String name = "";
        static String email = "";
        static String phone = "";
        static String password = "";

        public static void main(String[] args) {

            while (true) {

                System.out.println("************** QUẢN LÝ NGƯỜI DÙNG **************");
                System.out.println("1. Nhập thông tin người dùng");
                System.out.println("2. Chuẩn hóa họ tên");
                System.out.println("3. Kiểm tra email hợp lệ");
                System.out.println("4. Kiểm tra số điện thoại hợp lệ");
                System.out.println("5. Kiểm tra mật khẩu hợp lệ");
                System.out.println("6. Thoát");

                System.out.print("Lựa chọn của bạn: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        nhapThongTin();
                        break;

                    case 2:
                        chuanHoaTen();
                        break;

                    case 3:
                        kiemTraEmail();
                        break;

                    case 4:
                        kiemTraPhone();
                        break;

                    case 5:
                        kiemTraPassword();
                        break;

                    case 6:
                        System.out.println("Thoát chương trình");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                }
            }
        }

        static void nhapThongTin() {

            System.out.print("Nhập họ tên: ");
            name = sc.nextLine();

            System.out.print("Nhập email: ");
            email = sc.nextLine();

            System.out.print("Nhập số điện thoại: ");
            phone = sc.nextLine();

            System.out.print("Nhập mật khẩu: ");
            password = sc.nextLine();
        }

        static void chuanHoaTen() {

            String[] words = name.trim().toLowerCase().split("\\s+");

            StringBuilder result = new StringBuilder();

            for (String word : words) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }

            System.out.println("Tên sau khi chuẩn hóa: " + result.toString().trim());
        }

        static void kiemTraEmail() {

            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

            if (email.matches(regex)) {
                System.out.println("Email hợp lệ");
            } else {
                System.out.println("Email không hợp lệ");
            }
        }

        static void kiemTraPhone() {

            String regex = "^(0|\\+84)[0-9]{9}$";

            if (phone.matches(regex)) {
                System.out.println("Số điện thoại hợp lệ");
            } else {
                System.out.println("Số điện thoại không hợp lệ");
            }
        }

        static void kiemTraPassword() {

            String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

            if (password.matches(regex)) {
                System.out.println("Mật khẩu hợp lệ");
            } else {
                System.out.println("Mật khẩu không hợp lệ");
            }
        }
    }

