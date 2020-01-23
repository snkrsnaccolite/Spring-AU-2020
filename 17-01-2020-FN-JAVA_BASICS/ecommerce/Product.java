package ecommerce;

public class Product {
    public Integer id;
    public String name;
    public Double price;
    public Integer quantity;

    public Product(String name, Double price, Integer quantity) {
        Integer min = 1;
        Integer max = 1000000;

        this.id = (int)(Math.random() * ((max - min) + 1)) + min;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
