package Baiseasion17;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    public void addProduct(Product product) throws Exception {

        String checkSql = "SELECT * FROM products WHERE name = ?";
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement check = conn.prepareStatement(checkSql);
        check.setString(1, product.getName());

        ResultSet rs = check.executeQuery();

        if(rs.next()){
            System.out.println("Product already exists!");
            return;
        }

        String sql = "INSERT INTO products(name,price) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());

        ps.executeUpdate();
        System.out.println("Product added!");
    }

    public void updateCustomer(int id, Customer customer) throws Exception{

        String sql = "UPDATE customers SET name=?, email=? WHERE id=?";
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, customer.getName());
        ps.setString(2, customer.getEmail());
        ps.setInt(3, id);

        int rows = ps.executeUpdate();

        if(rows == 0){
            System.out.println("Customer not found");
        }else{
            System.out.println("Customer updated");
        }
    }

    public void createOrder(Order order) throws Exception{

        String sql = "INSERT INTO orders(customer_id,order_date,total_amount) VALUES(?,?,?)";

        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, order.getCustomerId());
        ps.setDate(2, order.getOrderDate());
        ps.setDouble(3, order.getTotalAmount());

        ps.executeUpdate();

        System.out.println("Order created!");
    }

    public void listAllOrders() throws Exception{

        String sql =
                "SELECT o.id,c.name,o.order_date,o.total_amount " +
                        "FROM orders o JOIN customers c ON o.customer_id=c.id";

        Connection conn = ConnectionDB.getConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){

            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getDate("order_date") + " | " +
                            rs.getDouble("total_amount")
            );
        }
    }

    public void getOrdersByCustomer(int customerId) throws Exception{

        String sql = "SELECT * FROM orders WHERE customer_id=?";

        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, customerId);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            System.out.println(
                    rs.getInt("id")+" | "+
                            rs.getDate("order_date")+" | "+
                            rs.getDouble("total_amount")
            );
        }
    }
}
