package Baiseasion17;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {

    public void addBook(Book book) {

        try {
            Connection conn = ConnectionDB.getConnection();

            String checkSQL =
                    "SELECT * FROM books WHERE title=? AND author=?";
            PreparedStatement check = conn.prepareStatement(checkSQL);

            check.setString(1, book.getTitle());
            check.setString(2, book.getAuthor());

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("Book already exists!");
                return;
            }

            String sql =
                    "INSERT INTO books(title,author,published_year,price) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublishedYear());
            ps.setDouble(4, book.getPrice());

            ps.executeUpdate();

            System.out.println("Add book success!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(int id, Book book) {

        try {

            Connection conn = ConnectionDB.getConnection();

            String checkSQL = "SELECT * FROM books WHERE id=?";
            PreparedStatement check = conn.prepareStatement(checkSQL);
            check.setInt(1, id);

            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("Book not found!");
                return;
            }

            String sql =
                    "UPDATE books SET title=?,author=?,published_year=?,price=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublishedYear());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, id);

            ps.executeUpdate();

            System.out.println("Update success!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {

        try {

            Connection conn = ConnectionDB.getConnection();

            String checkSQL = "SELECT * FROM books WHERE id=?";
            PreparedStatement check = conn.prepareStatement(checkSQL);
            check.setInt(1, id);

            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("Book not found!");
                return;
            }

            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Delete success!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findBooksByAuthor(String author) {

        try {

            Connection conn = ConnectionDB.getConnection();

            String sql = "SELECT * FROM books WHERE author LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + author + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getInt("published_year") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listAllBooks() {

        try {

            Connection conn = ConnectionDB.getConnection();

            String sql = "SELECT * FROM books";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getInt("published_year") + " | " +
                                rs.getDouble("price")
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}