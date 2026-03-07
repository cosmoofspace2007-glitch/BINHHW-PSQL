package Baiseasion18;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while(true){

            System.out.println("====== PRODUCT MANAGEMENT ======");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Sắp xếp theo giá");
            System.out.println("7. Thoát");

            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    List<Product> list = dao.getAllProducts();
                    list.forEach(p ->
                            System.out.println(p.getId()+" | "+p.getName()+" | "+p.getPrice())
                    );
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    float price = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Catalog: ");
                    String catalog = sc.nextLine();

                    Product p = new Product(name,price,title,new Date(),catalog,true);

                    dao.addProduct(p);

                    System.out.println("Add success!");
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Price: ");
                    float newPrice = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("New Catalog: ");
                    String newCatalog = sc.nextLine();

                    Product update = new Product(newName,newPrice,newTitle,new Date(),newCatalog,true);
                    update.setId(id);

                    dao.updateProduct(update);

                    break;

                case 4:
                    System.out.print("ID delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteProduct(deleteId);

                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Search name: ");
                    String key = sc.nextLine();

                    dao.searchByName(key).forEach(n ->
                            System.out.println(n.getId()+" | "+n.getName()+" | "+n.getPrice())
                    );

                    break;

                case 6:
                    dao.sortByPrice().forEach(m ->
                            System.out.println(m.getId()+" | "+m.getName()+" | "+m.getPrice())
                    );
                    break;

                case 7:
                    return;
            }
        }
    }
}