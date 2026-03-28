package com.example.product_management.Baiss1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController
{
   private final ProductService productService;

   @GetMapping
    public List<Product> getAllProduct()
    {
        return productService.getAllProducts();
    }

}
