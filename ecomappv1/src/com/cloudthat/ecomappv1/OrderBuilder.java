package com.cloudthat.ecomappv1;

import java.util.Date;

public interface OrderBuilder {

    OrderBuilder setOrderId(int orderId);
    OrderBuilder setCustomer(Customer customer);
    OrderBuilder setOrderDate(Date orderDate);
    OrderBuilder addProduct(Product product);
    Order build();
}
