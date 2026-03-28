package com.example.product_management.Baiss2;

import java.util.ArrayList;
import java.util.List;

public class UserRepository
{
    private List<User> user =  new ArrayList<>();

    public UserRepository()
    {
        user.add(new User(1, "Nguyễn Văn A", "A@gmail.com","Nhân viên"));
        user.add(new User(2, "Trần Văn C", "C@gmail.com","Quản lý"));
        user.add(new User(3, "Vương Thị T", "T@gmail.com","Giám đốc"));
    }

    public List<User> findAll()
        {
        return user;
        }

    User findById(int id)
    {
        for(User u : user)
        {
           if(u.getId() == id)
           {
               return u;
           }
           else
           {
               System.out.println("Ko tồn tại nguời dùng");
           }
        }
        return null;
    }
}
