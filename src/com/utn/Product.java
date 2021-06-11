package com.utn;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private static final long serialVersionUID = 7970889473436230100L;

    private static int counter = 1;
    private int idProduct;
    private String name;
    private  String description;
    private Double price;

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.idProduct = counter++;
    }
    public static void setCounter(Integer counter) {
        Product.counter = counter;
    }

    public String getName() {
        return name;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct);
    }
}
