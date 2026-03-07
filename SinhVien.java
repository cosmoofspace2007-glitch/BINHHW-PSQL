package Baiseasion6;
import java.util.Scanner;
public class SinhVien
{

        static Scanner sc = new Scanner(System.in);
        static double[] arr = new double[100];
        static int n = 0;

        public static void main(String[] args) {

            while (true) {

                System.out.println("************QUẢN LÝ ĐIỂM SV************");
                System.out.println("1. Nhập danh sách điểm sinh viên");
                System.out.println("2. In danh sách điểm");
                System.out.println("3. Tính điểm trung bình của các sinh viên");
                System.out.println("4. Tìm điểm cao nhất và thấp nhất");
                System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
                System.out.println("6. Sắp xếp điểm tăng dần");
                System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
                System.out.println("8. Thoát");

                System.out.print("Lựa chọn của bạn: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        nhapDiem();
                        break;

                    case 2:
                        inDanhSach();
                        break;

                    case 3:
                        tinhTrungBinh();
                        break;

                    case 4:
                        timMaxMin();
                        break;

                    case 5:
                        demDatTruot();
                        break;

                    case 6:
                        sapXep();
                        break;

                    case 7:
                        thongKeGioiXuatSac();
                        break;

                    case 8:
                        System.out.println("Thoát chương trình");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                }
            }
        }

        static void nhapDiem() {
            System.out.print("Nhập số lượng sinh viên: ");
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Nhập điểm sinh viên " + (i + 1) + ": ");
                arr[i] = sc.nextDouble();
            }
        }

        static void inDanhSach() {
            System.out.println("Danh sách điểm:");

            for (int i = 0; i < n; i++) {
                System.out.println("SV " + (i + 1) + ": " + arr[i]);
            }
        }

        static void tinhTrungBinh() {
            double sum = 0;

            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }

            System.out.println("Điểm trung bình: " + (sum / n));
        }

        static void timMaxMin() {

            double max = arr[0];
            double min = arr[0];

            for (int i = 1; i < n; i++) {

                if (arr[i] > max) {
                    max = arr[i];
                }

                if (arr[i] < min) {
                    min = arr[i];
                }
            }

            System.out.println("Điểm cao nhất: " + max);
            System.out.println("Điểm thấp nhất: " + min);
        }

        static void demDatTruot() {

            int dat = 0;
            int truot = 0;

            for (int i = 0; i < n; i++) {

                if (arr[i] >= 5) {
                    dat++;
                } else {
                    truot++;
                }
            }

            System.out.println("Số sinh viên đạt: " + dat);
            System.out.println("Số sinh viên trượt: " + truot);
        }

        static void sapXep() {

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {

                    if (arr[i] > arr[j]) {

                        double temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            System.out.println("Danh sách sau khi sắp xếp:");
            inDanhSach();
        }

        static void thongKeGioiXuatSac() {

            int gioi = 0;
            int xuatSac = 0;

            for (int i = 0; i < n; i++) {

                if (arr[i] >= 8 && arr[i] < 9) {
                    gioi++;
                }

                if (arr[i] >= 9) {
                    xuatSac++;
                }
            }

            System.out.println("Số sinh viên giỏi: " + gioi);
            System.out.println("Số sinh viên xuất sắc: " + xuatSac);
        }
    }

