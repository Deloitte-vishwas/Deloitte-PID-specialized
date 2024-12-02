package com.cloudthat.ecomappv3.entity;

import java.util.ArrayList;
import java.util.List;

public class Order implements Entity<Long> {

    private Long id;
    private Customer customer;
    private List<Product> products;

    public Order() {
    }

    public Order(Long id, Customer customer, List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public Order(Long id, Customer customer, Product product) {
        this.id = id;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.products.add(product);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
