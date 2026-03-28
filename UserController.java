package com.example.product_management.Baiss2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController
{
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false) String search)
    {
        List<User> listuser = userService.findAllUsers();
        if (!search.isEmpty() && search != null)
        {
            List<User> filter = new ArrayList<>();

            for(User user : listuser)
            {
                if(user.getUsername().toLowerCase().contains(search.toLowerCase()))
                {
                    filter.add(user);
                }
            }
            listuser = filter;
        }
        return ResponseEntity.ok(listuser);
    }
}
