package Baiseasion13;

import java.util.ArrayList;

public class OrderManger implements Manage3<Order>
{
    ArrayList<Order> order = new ArrayList<>();

    @Override
    public void add(Order o)
    {
        order.add(o);
        System.out.println("Đơn hàng đã được thêm thành công");
    }

    @Override
    public void update(int index, Order o)
    {
        for(Order i : order)
        {
            if(i.getId() == o.getId())
            {
                i.setId(o.getId());
                i.setName(o.getName());
                System.out.println("Đã cập nhật thành công");
            }
            else
            {
                System.out.println("Chưa cập nhật thành công");
            }
        }
    }

    @Override
    public void delete(int index)
    {
        boolean remove = order.removeIf(i -> i.getId() == index);

        if (remove)
        {
            System.out.println("Đã xoá thành công");
        }
        else
        {
            System.out.println("Chưa xoá thành công");
        }
    }

    @Override
    public void display()
    {
        for(Order i : order)
        {
            System.out.println(i);
            System.out.println("Đã hiển thị danh sách");
        }

        if (order.isEmpty())
        {
            System.out.println("Danh sách rỗng");
        }
    }
}

