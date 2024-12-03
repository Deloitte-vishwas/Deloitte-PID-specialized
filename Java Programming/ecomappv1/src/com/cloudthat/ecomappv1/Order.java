package com.cloudthat.ecomappv1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int orderId;
    private Date orderDate;
    private Customer customer;
    private List<Product> products;

    public Order() {

        this.products = new ArrayList<Product>();
    }

    public Order(int orderId, Date orderDate, Customer customer, List<Product> products) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public void addProduct(Product product){
        this.products.add(product);
    }

    public double calculateTotalPrice(List<Product> products){
        double totalPrice = 0;
        for (Product p: products){
            totalPrice += p.getPrice();
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
