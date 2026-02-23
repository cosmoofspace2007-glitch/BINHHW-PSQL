package Baiseasion13;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentManage implements Manage4<Student2>
{
    ArrayList<Student2> students = new ArrayList<Student2>();

    @Override
    public void add(Student2 s)
    {
        students.add(s);
        System.out.println("Đã thêm học sinh thành công");
    }

    @Override
    public void display()
    {
        for (Student2 s:students)
        {
            System.out.println(s);
        }
    }

    @Override
    public void search(String n)
    {
        boolean found = false;
        for(Student2 s:students)
        {
            if(s.getName().trim().equalsIgnoreCase(n.trim()))
            {
                System.out.println("Đã tìm thấy thấy sinh viên" + s);
                found = true;
            }
        }
        if(!found)
        {
            System.out.println("Sinh viên ko tồn tại");
        }
    }

    @Override
    public void classify()
    {
        for(Student2 s:students)
        {
            System.out.println(s.getName());

            if(s.getGpa() >= 8.5)
            {
                System.out.println("Xuất sắc");
            }
            else if (7.0 <= s.getGpa() && s.getGpa() < 8.5)
            {
                System.out.println("Giỏi");
            }
            else if (5.5 <= s.getGpa() && s.getGpa() < 7)
            {
                System.out.println("Khá");
            }
            else if (s.getGpa() < 5.5)
            {
                System.out.println("Trung bình/Yếu");
            }
        }
    }
}
