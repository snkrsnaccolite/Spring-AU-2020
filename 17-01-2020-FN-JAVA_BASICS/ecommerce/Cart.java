package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product removeProduct(int index) {
        return products.remove(index);
    }

    public List<Product> getAll() {
        return this.products;
    }

    public Double getTotalPrice() {
        Double totalPrice = 0.0;

        for (Product p : products) {
            totalPrice += p.price;
        }

        return totalPrice;
    }

    public void clear() {
        products.clear();
    }
}
