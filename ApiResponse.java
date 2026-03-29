package com.example.product_management.Baiss3;

import lombok.AllArgsConstructor;


public class ApiResponse<T>
{
    private boolean success;
    private String message;
    private T data;

    public ApiResponse(boolean success, String message, T data)
    {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
