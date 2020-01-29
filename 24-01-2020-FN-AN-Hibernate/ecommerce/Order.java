package ecommerce;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    private Integer id;
    private String username;

    @OneToMany
    @JoinTable(name="ORDER_PRODUCTS", joinColumns=@JoinColumn(name="ORDER_ID"), inverseJoinColumns=@JoinColumn(name="PRODUCT_ID"))
    public Collection<Product> products = new ArrayList<Product>();

    public Order(String username) {
        Integer min = 1;
        Integer max = 1000000;

        this.id = (int)(Math.random() * ((max - min) + 1)) + min;
        this.username = username;
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Collection<Product> getProducts() {
        return this.products;
    }
    public void addProduct(Product product) {
        this.products.add(product);
    }
    public Double getAmount() {
        Double totalPrice = 0.0;

        for (Product p : products) {
            totalPrice += p.getPrice();
        }

        return totalPrice;
    }
    public void clear() {
        this.products.clear();
    }
}
