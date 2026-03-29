package com.example.product_management.Baiss3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course
{
    private int id;
    private String title;
    private String status;
    private String instructorId;
}
