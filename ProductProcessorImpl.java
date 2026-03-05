package Baiseasion16;

import java.util.ArrayList;
import java.util.List;

public class ProductProcessorImpl implements ProductProcessor
{
    List<Product1> products = new ArrayList<Product1>();
    @Override
    public double calculateTotalValue(List<Product1> products)
    {
        double total = 0;
        for(Product1 p : products)
        {
            total += p.getPrice();
        }
        return total;
    };
}
