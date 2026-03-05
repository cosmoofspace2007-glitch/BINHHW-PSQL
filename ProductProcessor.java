package Baiseasion16;

import java.util.ArrayList;
import java.util.List;

public interface ProductProcessor
{

    double calculateTotalValue(List<Product1> products);


    static void printProductList(List<Product1> products)
    {
       for (Product1 pro : products)
        {
            System.out.println(pro);
        }
    };

    default boolean hasExpensiveProduct(List<Product1> products)
    {
        for(Product1 pro : products)
        {
            if(pro.getPrice() > 100)
            {
                return true;
            }
        }
        return false;
    };


}
