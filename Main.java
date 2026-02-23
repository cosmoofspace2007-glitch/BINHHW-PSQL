package Baiseasion13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
          StudentManage sm = new StudentManage();
//        OrderManger ordermanger = new OrderManger();
//        InvoiceManager invoiceManager = new InvoiceManager();
//        AttendanceManager manager = new AttendanceManager();
//        LinkedList<User> users = new LinkedList<User>();
//
//        while(true)
//        {
//        System.out.println("***************** MENU Quản Lý Người Dùng *****************\n"+
//                "1.Thêm người dùng\n"+
//                "2. Xoá người dùng\n"+
//                "3.Hiển thị danh sách người dùng\n"+
//                "4.Thoát");
//        System.out.println("Nhập vào lựa chọn của bạn");
//
//        int choice = scan.nextInt();
//        scan.nextLine();
//
//        switch(choice)
//        {
//            case 1:
//                System.out.println("Nhập vào tên người dùng");
//                String name = scan.nextLine();
//                System.out.println("Nhập vào email người dùng");
//                String email = scan.nextLine();
//                System.out.println("Nhập vào số điện thoại người dùng");
//                String number = scan.next();
//
//                users.add(new User(name, email, number));
//                break;
//
//            case 2:
//                System.out.println("Nhập vào email bạn muốn xoá:");
//                String e = scan.nextLine();
//
//                boolean remove = users.removeIf(user -> user.getEmail().equalsIgnoreCase(e));
//
//                if (remove) {
//                    System.out.println("Xoá Thành công");
//                } else {
//                    System.out.println("KO xoá thành công");
//                }
//                break;
//
//            case 3:
//                for (User u : users) {
//                    System.out.println(u);;
//                }
//                break;
//
//            case 4:
//                System.out.println("Đã thoát chương trình");
//                break;
//                default:
//                    System.out.println("Tiếp tục chọn chức năng");
//
//        }
//    }

//          while (true)
//          {
//              System.out.println("****************** MENU Quản Lý Điểm Danh ******************\n"
//                                 "1. Thêm Sinh viên\n" +
//                                 "2. Sửa sinh viên\n" +
//                                 "3. Xoá sinh viên\n" +
//                                 "4. Hiện thị danh sách sinh viên\n" +
//                                 "5. Thoát");
//              System.out.println("Nhập vào lựa chọn của bạn: ");
//
//              int c = scan.nextInt();
//              scan.nextLine();
//              switch (c)
//                  {
//                  case 1:
//                      System.out.print("Nhập vào tên học sinh");
//                      String name = scan.nextLine();
//                      System.out.println("Nhập vào id học sinh");
//                      int id = scan.nextInt();
//
//                      manager.add(new Student(name,id));
//                      break;
//
//                  case 2:
//                      manager.display();
//                      System.out.println("Nhập vào id cần sửa");
//                      int up = Integer.parseInt(scan.nextLine());
//                      System.out.println("Nhập vào tên mới ");
//                      String n = scan.nextLine();
//                      manager.update(up,new Student(n,up));
//                      break;
//
//                  case 3:
//                      manager.display();
//                      System.out.println("Nhập vào vị trí bạn muốn xoá");
//                      int d = Integer.parseInt(scan.nextLine());
//                      manager.delete(d);
//                      break;
//
//                  case 4:
//                      System.out.println("Hiển thị danh sách sinh viên");
//                      manager.display();
//                      break;
//
//                  case 5:
//                      System.out.println("Đã thoát chương trình");
//                  }
//          }

//        while (true)
//        {
//            System.out.println("******************* MENU Quản Lý Đơn Hàng *******************\n" +
//                               "1. Thêm Hoá Đơn\n" +
//                               "2. Sửa Hoá Đơn\n" +
//                               "3. Xoá Hoá Đơn\n" +
//                               "4. Hiện Danh Sách Hoá Đơn\n" +
//                               "5. Thoát");
//            System.out.println("Nhập vào lựa chọn của bạn");
//
//            int choice = scan.nextInt();
//
//            switch (choice)
//                {
//                case 1:
//                    System.out.println("Nhập vào id");
//                    int id = scan.nextInt();
//                    scan.nextLine();
//                    System.out.println("Nhập mã hoá đơn của bạn");
//                    String h =  scan.nextLine();
//                    System.out.println("Nhập số tiền");
//                    int a =  scan.nextInt();
//                    if(a <= 0)
//                    {
//                        System.out.println("Vui lòng nhập số tiền lớn hơn hoặc bằng 0");
//                    }
//                    else
//                    {
//                        invoiceManager.add(new Invoice(id,a,h));
//                        System.out.println("Nhập vào thành công");
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("Nhập vào id cần sửa");
//                    int i = scan.nextInt();
//                    scan.nextLine();
//                    System.out.println("Nhập vào mã hoá đơn mới");
//                    String m =  scan.nextLine();
//                    System.out.println("Nhập vào số tiền mới");
//                    int n =  scan.nextInt();
//                    invoiceManager.update(i,new Invoice(i,n,m));
//                    break;
//
//                case 3:
//                    System.out.println("Nhập vào id hoá đơn cần xoá");
//                    int x = scan.nextInt();
//                    invoiceManager.delete(x);
//                    break;
//
//                case 4:
//                    System.out.println("Hiên thị danh sách hoá đơn");
//                    invoiceManager.display();
//                    break;
//
//                case 5:
//                    System.out.println("Đã thoát chương trình");
//                    break;
//                }
//
//        }

//        while (true)
//        {
//            System.out.println("********************* MENU Quản Lý Đơn Hàng *********************\n" +
//                               "1. Thêm đơn hàng\n" +
//                               "2. Sửa đơn hàng\n" +
//                               "3. Xoá đơn hàng\n" +
//                               "4. Hiện thị danh sách đơn hàng\n" +
//                               "5. Thoát");
//            System.out.println("nhập vào lựa chọn của bạn");
//            int choice = scan.nextInt();
//
//            switch (choice)
//                {
//                case 1:
//                    System.out.println("Nhập vào id");
//                    int id = scan.nextInt();
//                    scan.nextLine();
//                    System.out.println("Nhập vào tên khách hàng");
//                    String name = scan.nextLine();
//
//                    ordermanger.add(new Order(name,id));
//                    break;
//
//                case 2:
//                    System.out.println("Nhập vào id cần chỉnh sửa");
//                    int a = scan.nextInt();
//                    scan.nextLine();
//                    System.out.println("Nhập vào tên mới");
//                    String b = scan.nextLine();
//                    ordermanger.update(a,new Order(b,a));
//                    break;
//
//                case 3:
//                    System.out.println("Nhập vào id cần xoá");
//                    int x = scan.nextInt();
//                    ordermanger.delete(x);
//                    break;
//
//                case 4:
//                    System.out.println("Hiển thị danh sách");
//                    ordermanger.display();
//                    break;
//                }
//        }

       while (true)
       {
           System.out.println("********************* MENU *********************\n" +
                              "1. Nhập danh sách sinh viên\n" +
                              "2. In danh sách sinh viên\n" +
                              "3. Tìm kiếm sinh viên theo tên\n" +
                              "4. Phân loại sinh viên theo GPA\n" +
                              "0. Thoát chương trình");
           System.out.println("Nhập vào lựa chọn của bạn");
           int choice = scan.nextInt();
           switch(choice)
               {
               case 1:
                   System.out.println("Nhập vào id sinh viên");
                   int n =  scan.nextInt();
                   scan.nextLine();
                   System.out.println("Nhập vào tên sinh viên");
                   String name =  scan.nextLine();
                   System.out.println("Nhập vào GPA của sinh viên");
                   double gpa = scan.nextDouble();

                   sm.add(new Student2(n, name, gpa));
                   break;

               case 2:
                   System.out.println("Hiển thị danh sách học sinh");
                   sm.display();
                   System.out.println("Đã hiển thị danh sách học sinh");
                   break;

               case 3:
                   System.out.println("Nhập vào tên sinh viên cần tìm");
                   String m = scan.nextLine();
                   sm.search(m);
                   break;

               case 4:
                   System.out.println("Phân loại sinh viên");
                   sm.classify();
                   break;
               }
       }
    }
}
