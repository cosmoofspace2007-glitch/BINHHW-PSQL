package Baiseasion17;

import java.sql.*;

public class TaskManagement {

    public void addTask(String name, String status) {

        try {
            Connection conn = ConnectionDB.getConnection();

            CallableStatement cs =
                    conn.prepareCall("{call add_task(?,?)}");

            cs.setString(1, name);
            cs.setString(2, status);

            cs.executeUpdate();

            System.out.println("Add success!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void listTasks() {

        try {

            Connection conn = ConnectionDB.getConnection();

            CallableStatement cs =
                    conn.prepareCall("{call list_tasks()}");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status")
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateTaskStatus(int id, String status) {

        try {

            Connection conn = ConnectionDB.getConnection();

            CallableStatement cs =
                    conn.prepareCall("{call update_task_status(?,?)}");

            cs.setInt(1, id);
            cs.setString(2, status);

            cs.executeUpdate();

            System.out.println("Update success!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteTask(int id) {

        try {

            Connection conn = ConnectionDB.getConnection();

            CallableStatement cs =
                    conn.prepareCall("{call delete_task(?)}");

            cs.setInt(1, id);

            cs.executeUpdate();

            System.out.println("Delete success!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchTaskByName(String name) {

        try {

            Connection conn = ConnectionDB.getConnection();

            CallableStatement cs =
                    conn.prepareCall("{call search_task_by_name(?)}");

            cs.setString(1, name);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status")
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void taskStatistics() {

        try {

            Connection conn = ConnectionDB.getConnection();

            CallableStatement cs =
                    conn.prepareCall("{call task_statistics()}");

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getString("status") + " : " +
                                rs.getInt("total")
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
