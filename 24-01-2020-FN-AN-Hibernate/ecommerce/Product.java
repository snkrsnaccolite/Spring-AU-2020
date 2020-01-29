package ecommerce;

import javax.persistence.*;

@Entity
@Table(name="Products")
public class Product {
    @Id
    private Integer id;
    private String name;
    private Double price;

    public Product(String name, Double price) {
        Integer min = 1;
        Integer max = 1000000;

        this.id = (int)(Math.random() * ((max - min) + 1)) + min;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
