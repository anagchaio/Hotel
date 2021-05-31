package com.utn;

import java.util.ArrayList;
import java.util.List;

public class Consumption {
    private static int counter = 1;
    private int id;
    private List<Product> products = new ArrayList<>();
    private Double totalPrice;

    public Consumption(List<Product> products) {
        this.products = products;
        this.totalPrice = calculateTotalPrice();
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    private Double calculateTotalPrice() {
        Double totalPrice = 0.00;
        for (Product p: this.products) {
            totalPrice += p.getPrice();
        }
       return totalPrice;
    }
}
