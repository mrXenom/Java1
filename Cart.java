package org.example;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
public class Cart {
    private List<Product> products;
    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    // Метод для видалення товару з кошика
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
    public List<Product> getProducts() {
        return new ArrayList<>(products); // Повертаємо копію списку, щоб запобігти змінам ззовні
    }
    public void clear() {
        products.clear(); // Очищення списку товарів у кошику
    }


}
