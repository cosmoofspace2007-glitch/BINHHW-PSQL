package Baiseasion16;

import Baiseasion13.Invoice;
import Baiseasion13.Manage;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        List<Product1> products = new ArrayList<Product1>();
//        List<Message> messages = new ArrayList<Message>();
//        ArrayList<Event> events = new ArrayList<Event>();
//        HashMap<Integer, Product> products = new HashMap<Integer, Product>();

//        while (true)
//        {
//            System.out.println("--------- Product Management System -----------\n" +
//                               "1. Add Product\n" +
//                               "2. Edit Product\n" +
//                               "3. Delete Product\n" +
//                               "4. Display All Products\n" +
//                               "5. Filter Product(Price > 1000)\n" +
//                               "6. Total Value of Product\n" +
//                               "0. Exit Program");
//            System.out.println("Nhập vào lựa chọn của bạn");
//            int choice = sc.nextInt();
//
//            switch (choice)
//                {
//                case 1:
//                    System.out.println("Enter Product ID");
//                    int id = sc.nextInt();
//                    System.out.println("Enter Product Amount");
//                    double amount = sc.nextDouble();
//                    System.out.println("Enter Product Name");
//                    String name = sc.next();
//
//                    Product p = new Product(name, id, amount);
//                    products.put(id, p);
//                    System.out.println("Product added successfully");
//                    break;
//
//                case 2:
//                    System.out.println("Enter Product ID");
//                    int m = sc.nextInt();
//                    System.out.println("Enter New Product Amount");
//                    double newAmount = sc.nextDouble();
//                    System.out.println("Enter New Product Name");
//                    String newName = sc.next();
//
//                    if(!products.containsKey(m))
//                    {
//                        System.out.println("Product does not exist");
//                    }
//
//                    for(Product p1 : products.values())
//                    {
//                        if(p1.getId() == m)
//                        {
//                            p1.setName(newName);
//                            p1.setPrice(newAmount);
//                            System.out.println("Edit Product successfully");
//                        }
//                        else
//                        {
//                            System.out.println("Edit Product not successfully");
//                        }
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Enter Product ID");
//                    int n = sc.nextInt();
//
//                    if(products.remove(n) != null)
//                        {
//                        System.out.println("Product deleted successfully");
//                        }
//                    else
//                    {
//                        System.out.println("Product not deleted successfully");
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("Revealing Product");
//                    products.values().forEach(System.out::println);
//                    break;
//
//                case 5:
//                    System.out.println("Product that have price > 100");
//
//                    products.values()
//                            .stream()
//                            .filter(p1 -> p1.getPrice() > 100)
//                            .forEach(System.out::println);
//                    break;
//
//                case 6:
//                    double total = products.values()
//                                   .stream()
//                                   .mapToDouble(Product::getPrice)
//                                   .sum();
//                    System.out.println("Total Value of Product" + total);
//                    break;
//
//                case 0:
//                    System.out.println("Exit the program");
//                }
//        }

//        while (true)
//        {
//            System.out.println("------------- Quản Lý Sự Kiện -------------\n" +
//                               "1.Thêm Sự kiện\n" +
//                               "2.Kiểm tra thời gian Sự kiện\n" +
//                               "3.In danh sách sự kiện\n" +
//                               "4.Xử lý ngoại lệ");
//            System.out.println("Nhập vào lựa chon của bạn");
//            int choice = sc.nextInt();
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy : HH:mm");
//
//            switch (choice)
//                {
//                case 1:
//
//                    System.out.println("Nhập vào tên sự kiện");
//                    String name = sc.next();
//                    sc.nextLine();
//
//                    System.out.println("Nhập vào thời gian bắt đầu");
//                    String p = sc.nextLine();
//                    LocalDateTime  startdate = LocalDateTime.parse(p,dtf);
//
//                    System.out.println("Nhập vào thời gian kết thúc");
//                    String date = sc.nextLine();j
//                    LocalDateTime  enddate = LocalDateTime.parse(date,dtf);
//
//                    events.add(new Event(name, startdate, enddate));
//                    System.out.println("Đã thêm sự kiện thành công");
//                    break;
//
//                case 2:
//                    System.out.println("Nhập vào tên sự kiện");
//                    String n =  sc.nextLine();
//
//                    for(Event e : events)
//                   {
//                    if(e.getName().trim().equalsIgnoreCase(n.trim())
//                    {
//                         e.getStartdate().format(dtf);
//                         e.getEnddate().format(dtf);
//                        if(e.getStartdate().isBefore(e.getEnddate()))
//                        {
//                            System.out.println("Sự kiện chuẩn bị xảy ra");
//                        }
//                        else
//                        {
//                            System.out.println("Sự kiện đã xảy ra");
//                        }
//                    }
//                    else
//                    {
//                        System.out.println("Hiển thị ko thành công");
//                    }
//                   }
//                    break;
//
//                case 3:
//                    System.out.println("Hiển thị danh sách sự kiện");
//                    for(Event e : events)
//                    {
//                        System.out.println(e);
//                    }
//                    break;
//
//                case 4:
//                    for(Event e : events)
//                    {
//                        try
//                        {
//                            LocalDateTime star = e.getStartdate();
//                            LocalDateTime end = e.getEnddate();
//                            System.out.println("Định dạng hợp lệ");
//                        }
//                        catch(DateTimeException dte)
//                        {
//                            System.out.println("Ko hợp lệ");
//                        }
//                    }
//                    break;
//
//                    case 5:
//                        System.out.println("Đã thoát chương trình");
//                    break;
//                }
//        }

//

        while (true)
        {
            System.out.println("------------ Danh Sách Quản Lý Sản Phẩm ------------\n" +
                               "1. Tạo danh sách sản phẩm\n" +
                               "2. Kiểm tra sản phẩm\n" +
                               "3. Tổng giá trị sản phẩm\n" +
                               "4. In toàn bộ danh sách");
            System.out.println("Nhập vào lựa chọn của bạn");
            int choice = sc.nextInt();

            switch (choice)
                {
                case 1:
                    System.out.println("Nhập vào tên sản phẩm");
                    String name = sc.nextLine();
                    System.out.println("Nhập vào giá sản phẩm");
                    double price = sc.nextDouble();

                    products.add(new Product1(name, price));
                    System.out.println("Đã thêm sản phẩm thành công");
                    break;

                case 2:
                  ProductProcessor m = new ProductProcessorImpl();
                  boolean result = m.hasExpensiveProduct(products);
                  System.out.println(result);
                  break;

                case 3:
                    ProductProcessor n = new ProductProcessorImpl();
                    double x = n.calculateTotalValue(products);
                    System.out.println(x);
                    break;

                case 4:
                    ProductProcessor pr = new ProductProcessorImpl();
                    ProductProcessor.printProductList(products);
                    break;

                }
        }


    }
}
