package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public Integer id;
    public String username;
    public Cart products;

    public Order(String username, Cart cart) {
        Integer min = 1;
        Integer max = 1000000;

        this.id = (int)(Math.random() * ((max - min) + 1)) + min;
        this.username = username;
        this.products = cart;
    }

    public Double getAmount() {
        return this.products.getTotalPrice();
    }
}
