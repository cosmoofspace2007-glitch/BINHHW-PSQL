package Baiseasion12;

import java.util.ArrayList;

public class MenuManager {

    ArrayList<Drink> menu = new ArrayList<>();

    public void addDrink(Drink d) {
        menu.add(d);
    }

    public void showMenu() {
        for (Drink d : menu) {
            d.display();
            d.prepare();
            System.out.println("----------------");
        }
    }

    public void applyDiscount(double percent) {
        for (Drink d : menu) {
            d.applyDiscount(percent);
        }
    }

    public void removeDrink(int id) {
        menu.removeIf(d -> d.getId() == id);
    }

    public void averagePrice() {

        if (menu.isEmpty()) {
            System.out.println("Menu empty");
            return;
        }

        double sum = 0;

        for (Drink d : menu) {
            sum += d.getPrice();
        }

        System.out.println("Average price: " + sum / menu.size());
    }
}
