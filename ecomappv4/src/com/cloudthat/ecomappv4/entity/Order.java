package com.cloudthat.ecomappv4.entity;

import com.cloudthat.ecomappv4.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class Order implements Entity<Long> {

    private Long id;
    private Long customerId;
    private List<Long> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public Order(Long id, Long customerId, List<Long> products) {
        this.id = id;
        this.customerId = customerId;
        this.products = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }

    public void setProducts(Long productId) {
        this.products.add(productId);
    }

    public static Order fromCSV(String s) {
        String[] fields = s.split(",");
        Order order = new Order();
        order.setId(Long.parseLong(fields[0]));
        order.setCustomerId(Long.parseLong(fields[1]));
        order.setProducts(Long.parseLong(fields[2]));
        return order;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", products=" + products +
                '}';
    }
}
