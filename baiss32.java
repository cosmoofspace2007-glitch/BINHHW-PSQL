package Baiseasion3;

import java.util.Scanner;
public class baiss32 {

        static Scanner sc = new Scanner(System.in);

        static int count = 0;
        static double sum = 0;
        static double max = Double.MIN_VALUE;
        static double min = Double.MAX_VALUE;

        public static void main(String[] args) {

            while (true) {
                System.out.println("===== MENU =====");
                System.out.println("1. Nhập điểm học viên");
                System.out.println("2. Hiển thị thống kê");
                System.out.println("3. Thoát");
                System.out.print("Lựa chọn của bạn: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        nhapDiem();
                        break;

                    case 2:
                        thongKe();
                        break;

                    case 3:
                        System.out.println("Kết thúc chương trình.");
                        System.exit(0);

                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }

        public static void nhapDiem() {

            System.out.println("--- Nhập điểm học viên (nhập -1 để dừng) ---");

            while (true) {

                System.out.print("Nhập điểm: ");
                double score = sc.nextDouble();

                if (score == -1) {
                    break;
                }

                if (score < 0 || score > 10) {
                    System.out.println("Điểm không hợp lệ. Nhập lại.");
                    continue;
                }

                count++;
                sum += score;

                if (score > max) {
                    max = score;
                }

                if (score < min) {
                    min = score;
                }

                System.out.println("Học lực: " + xepLoai(score));
            }
        }

        public static String xepLoai(double score) {

            if (score < 5) {
                return "Yếu";
            }
            else if (score < 7) {
                return "Trung bình";
            }
            else if (score < 8) {
                return "Khá";
            }
            else if (score < 9) {
                return "Giỏi";
            }
            else {
                return "Xuất sắc";
            }
        }

        public static void thongKe() {

            if (count == 0) {
                System.out.println("Chưa có dữ liệu.");
                return;
            }

            System.out.println("--- KẾT QUẢ ---");
            System.out.println("Số học viên đã nhập: " + count);
            System.out.println("Điểm trung bình: " + (sum / count));
            System.out.println("Điểm cao nhất: " + max);
            System.out.println("Điểm thấp nhất: " + min);
        }
    }


