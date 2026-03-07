package Baiseasion12;

import java.util.*;

class AssetManager {

    private List<Asset> list = new ArrayList<>();

    public void addAsset(Asset a) {
        list.add(a);
    }

    public void showAll() {
        for (Asset a : list) {
            showValue(a);
        }
    }

    public void showValue(Asset a) {
        System.out.println(a.toString());
    }

    // Overloading search
    public void search(String assetCode) {
        for (Asset a : list) {
            if (a.getAssetCode().equals(assetCode)) {
                System.out.println(a);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void search(double price) {
        for (Asset a : list) {
            if (a.getPurchasePrice() > price) {
                System.out.println(a);
            }
        }
    }

    public void updatePrice(String code, double newPrice) {
        for (Asset a : list) {
            if (a.getAssetCode().equals(code)) {
                a.setPurchasePrice(newPrice);
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Asset not found");
    }
}
