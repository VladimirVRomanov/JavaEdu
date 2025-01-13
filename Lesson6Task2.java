/*
    Реализовать класс корзины интернет магазина по следующему интерфейсу:
    interface Basket {
        void addProduct(String product, int quantity);
        void removeProduct(String product);
        void updateProductQuantity(String product, int quantity);
        void clear();
        List<String> getProducts();
        int getProductQuantity(String product);
    }
 */

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Lesson6Task2 {
    public static void main(String[] args) {
        var basket = new CBasket();
        basket.addProduct("Хлеб", 1);
        basket.addProduct("Молоко", 2);
        basket.addProduct("Сыр", 3);
        basket.addProduct("Чипсы", 4);
        basket.addProduct("Пиво", 5);
        basket.print();
        basket.updateProductQuantity("Пиво", 6);
        System.out.println("\nupdateProductQuantity(\"Пиво\", 6);");
        System.out.println("Пиво: " + basket.getProductQuantity("Пиво"));
        basket.print();
        basket.removeProduct("Молоко");
        System.out.println("\nremoveProduct(\"Молоко\");");
        basket.print();
        basket.clear();
        System.out.println("\nclear();");
        basket.print();
    }
}

interface Basket {
    void addProduct(String product, int quantity);
    void removeProduct(String product);
    void updateProductQuantity(String product, int quantity);
    void clear();
    List<String> getProducts();
    int getProductQuantity(String product);
}

class CBasket implements Basket {
    private Map<String, Integer> products;

    CBasket() {
        products = new LinkedHashMap<String, Integer>();
    }

    public void addProduct(String product, int quantity) {
        if (!products.containsKey(product))
            products.put(product, quantity);
    }

    public void removeProduct(String product) {
        products.remove(product);
    }

    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product))
            products.replace(product, quantity);
    }

    public void clear() {
        products.clear();
    }

    public List<String> getProducts() {
        return products.keySet().stream().toList();
    }

    public List<Integer> getQuantities() {
        return products.values().stream().toList();
    }

    public int getProductQuantity(String product) {
        return products.getOrDefault(product, 0);
    }

    public void print() {
        System.out.println("Товары: " + getProducts().toString());
        System.out.println("Количество: " + getQuantities().toString());
    }
}