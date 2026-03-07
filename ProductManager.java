package Baiseasion15;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public void removeProduct(int id){
        boolean found = false;

        for(Product p : products){
            if(p.getId() == id){
                products.remove(p);
                found = true;
                break;
            }
        }

        if(!found){
            throw new RuntimeException("Product not found");
        }
    }

    public void display(){
        for(Product p : products){
            System.out.println(p);
        }
    }

    public Product findById(int id){
        for(Product p : products){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
}
