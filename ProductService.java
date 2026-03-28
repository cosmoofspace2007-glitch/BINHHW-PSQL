package com.example.product_management.Baiss1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    List<Product> products =new ArrayList<Product>();

    public ProductService()
    {
        products.add(new Product(1,"Pan",10));
        products.add(new Product(2,"Piano",2000));
        products.add(new Product(3,"Paper",1));
    }

     public List<Product> getAllProducts()
     {
         return products;
     };
}
