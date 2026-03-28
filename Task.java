package com.example.product_management.Baiss2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task
{
    private int id;
    private String title;
    private String description;
    private String priority;
    private String assignedTo;
}
