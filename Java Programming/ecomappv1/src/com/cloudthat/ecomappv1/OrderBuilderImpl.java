package com.cloudthat.ecomappv1;

import java.util.Date;

public class OrderBuilderImpl implements OrderBuilder{
    private Order order;

    public OrderBuilderImpl(){
        order = new Order();
    }

    @Override
    public OrderBuilder setOrderId(int orderId) {
        order.setOrderId(orderId);
        return this;
    }

    @Override
    public OrderBuilder setCustomer(Customer customer) {
        order.setCustomer(customer);
        return this;
    }

    @Override
    public OrderBuilder setOrderDate(Date orderDate) {
        order.setOrderDate(orderDate);
        return this;
    }

    @Override
    public OrderBuilder addProduct(Product product) {
        order.addProduct(product);
        return this;
    }

    @Override
    public Order build() {
        return order;
    }
}
