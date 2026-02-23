package Baiseasion13;

import javax.naming.Name;
import java.util.ArrayList;

public class AttendanceManager implements Manage<Student>
{
    ArrayList<Student> s = new ArrayList<>();

    @Override
    public void add(Student item)
    {
       s.add(item);
        System.out.println("Đã thêm học sinh");
    }

    @Override
    public void update(int index, Student item)
    {
        for(Student st: s) {
            if (st.getId() == index)
            {
                st.setName(item.getName());
                st.setId(item.getId());
                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("Ko cập nhật thành công");
    }

    @Override
    public void delete(int index)
    {
        for(Student st: s)
        {
            if (st.getId() == index)
            {
                s.remove(st);
                System.out.println("Đã xoá học sinh");
            }
        }
        System.out.println("Chưa xoá học sinh");
    }

    @Override
    public void display()
    {
        if(s.isEmpty())
        {
            System.out.println("Danh sách rỗng");
        }
        else
        {
            for (Student item : s) {
                System.out.println(item);
            }
        }
    }


}
