package com.example.product_management.Baiss2;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository
{
    List<Task> tasks = new ArrayList<>();

    public TaskRepository()
    {
        tasks.add(new Task(1,"Giới Thiệu","Đi lại bán hàng", "Thử sản phẩm", "Nhân viên giới thiệu"));
        tasks.add(new Task(3,"Tiếp Khách","Nói chuyện,Tư Vấn", "Hiểu KHách", "Thư Ký"));
        tasks.add(new Task(2,"Sếp","Quản lý cấp dưới và duy trì ct", "Lợi nhuận", "CEO"));
    }

    public List<Task> findAll()
    {
        return tasks;
    }
}
