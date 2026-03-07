package Baiseasion18;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> getAllProducts() throws Exception {

        List<Product> list = new ArrayList<>();

        Connection conn = Baiseasion18.ConnectionDB.getConnection();
        String sql = "SELECT * FROM Product";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){

            Product p = new Product();

            p.setId(rs.getInt("Product_Id"));
            p.setName(rs.getString("Product_Name"));
            p.setPrice(rs.getFloat("Product_Price"));
            p.setTitle(rs.getString("Product_Title"));
            p.setCreated(rs.getDate("Product_created"));
            p.setCatalog(rs.getString("Product_catalog"));
            p.setStatus(rs.getBoolean("Product_Status"));

            list.add(p);
        }

        return list;
    }

    public void addProduct(Product p) throws Exception {

        String sql = "INSERT INTO Product(Product_Name,Product_Price,Product_Title,Product_created,Product_catalog,Product_Status) VALUES(?,?,?,?,?,?)";

        Connection conn = Baiseasion18.ConnectionDB.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,p.getName());
        ps.setFloat(2,p.getPrice());
        ps.setString(3,p.getTitle());
        ps.setDate(4,new java.sql.Date(p.getCreated().getTime()));
        ps.setString(5,p.getCatalog());
        ps.setBoolean(6,p.isStatus());

        ps.executeUpdate();
    }

    public void updateProduct(Product p) throws Exception{

        String sql = "UPDATE Product SET Product_Name=?,Product_Price=?,Product_Title=?,Product_catalog=? WHERE Product_Id=?";

        Connection conn = Baiseasion18.ConnectionDB.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,p.getName());
        ps.setFloat(2,p.getPrice());
        ps.setString(3,p.getTitle());
        ps.setString(4,p.getCatalog());
        ps.setInt(5,p.getId());

        ps.executeUpdate();
    }

    public void deleteProduct(int id) throws Exception{

        String sql = "DELETE FROM Product WHERE Product_Id=?";

        Connection conn = Baiseasion18.ConnectionDB.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1,id);

        ps.executeUpdate();
    }

    public List<Product> searchByName(String name) throws Exception{

        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM Product WHERE Product_Name LIKE ?";

        Connection conn = Baiseasion18.ConnectionDB.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,"%"+name+"%");

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            Product p = new Product();

            p.setId(rs.getInt("Product_Id"));
            p.setName(rs.getString("Product_Name"));
            p.setPrice(rs.getFloat("Product_Price"));
            p.setTitle(rs.getString("Product_Title"));
            p.setCatalog(rs.getString("Product_catalog"));

            list.add(p);
        }

        return list;
    }

    public List<Product> sortByPrice() throws Exception{

        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM Product ORDER BY Product_Price ASC";

        Connection conn = Baiseasion18.ConnectionDB.getConnection();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){

            Product p = new Product();

            p.setId(rs.getInt("Product_Id"));
            p.setName(rs.getString("Product_Name"));
            p.setPrice(rs.getFloat("Product_Price"));

            list.add(p);
        }

        return list;
    }
}
