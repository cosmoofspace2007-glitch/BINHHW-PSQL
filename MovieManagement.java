package Baiseasion17;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieManagement
{
  public void addMovie(String title, String director, int year)
  {
     try
     {
         Connection conn = ConnectionDB.getConnection();
         CallableStatement cs = conn.prepareCall("call film.addMovie(?,?,?)");

         cs.setString(1,title);
         cs.setString(2,director);
         cs.setInt(3,year);

         cs.execute();
         System.out.println("Thêm phim thành công");
     }
     catch(SQLException s)
     {
         s.printStackTrace();
     }
  }



    public void listMovie()
    {
        try
        {
            Connection conn = ConnectionDB.getConnection();
            CallableStatement cs = conn.prepareCall("call film.listMovie() ");

            ResultSet rs = cs.executeQuery();

            while(rs.next())
            {
                System.out.println(
                        rs.getInt("id") + "|" +
                        rs.getString("title") + "|" +
                        rs.getString("director") +  "|" +
                        rs.getInt("year")
                );
            }
            System.out.println("hiển thị thành công");
        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
    }



  public void updateMovie(int id,String title, String director, int year)
  {
      try
      {
          Connection conn = ConnectionDB.getConnection();
          CallableStatement cs = conn.prepareCall("call film.updateMovie(?,?,?,?) ");

          cs.setInt(1,id);
          cs.setString(2,title);
          cs.setString(3,director);
          cs.setInt(4,year);

          cs.execute();
          System.out.println("Cập nhật phim thành công");

      }
      catch(SQLException s)
      {
          s.printStackTrace();
      }
  }



    public void deleteMovie(int id)
    {
        try
        {
            Connection conn = ConnectionDB.getConnection();
            CallableStatement cs = conn.prepareCall("call film.deleteMovie(?) ");

            cs.setInt(1,id);

            cs.execute();
            System.out.println("Xoá thành công");

        }
        catch(SQLException s)
        {
            s.printStackTrace();
        }
    }


}
