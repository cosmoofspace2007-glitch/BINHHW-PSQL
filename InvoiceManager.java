package Baiseasion13;

import java.util.ArrayList;

public class InvoiceManager implements Manage2<Invoice>
{
    ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    @Override
    public void add(Invoice item)
    {
       invoices.add(item);
        System.out.println("Đã thêm thành công");
    }

    @Override
    public void update(int index, Invoice item)
    {
        for(Invoice i : invoices)
        {
            if(i.getId() == index)
            {
                i.setAmount(item.getAmount());
                i.setDescrip(item.getDescrip());
                i.setId(item.getId());
                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("Ko cập nhật thành công");
    }

    @Override
    public void delete(int index)
    {
       boolean remove = invoices.removeIf(i -> i.getId() == index);
        if(remove)
        {
            System.out.println("Đã xoá thành công");
        }
        else
        {
            System.out.println("Chưa Xoá thành công");
        }
    }

    @Override
    public void display()
    {
        for(Invoice i : invoices)
        {
            System.out.println(i);
        }

        if(invoices.isEmpty())
        {
            System.out.println("Danh sách rỗng");
        }
    }

}
