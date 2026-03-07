package Baiseasion18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB
{
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/productmanagement";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "BINH1234" ;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection Conn =  getConnection();
        System.out.println("Coon" + Conn);
        System.out.println("Status: " + Conn.isClosed());

        closeConnection(Conn);
        System.out.println("After close: " + Conn.isClosed());
    }
}

