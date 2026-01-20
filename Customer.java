public class Customer {
    int id;
    String name;
    String email;

    void showInfo(){
        System.out.println(id);
        System.out.println(name);
    }
}

class Order extends Customer{
      int orderId;
      Customer customer;
      double total;

      void printOrder(){
          System.out.println("Order #"+orderId);
          System.out.println("Customer #"+customer.id);
          System.out.println("Total #"+total);
      }
}
