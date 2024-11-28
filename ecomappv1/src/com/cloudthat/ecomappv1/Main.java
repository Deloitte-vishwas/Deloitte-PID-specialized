package com.cloudthat.ecomappv1;

import com.cloudthat.ecomappv1.exceptions.MinimumQuantityException;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Ecommerce App");
        Product p1 = null;
        Product p2 = null;

        try {
            // Creating Products
            p1 = new Product();
            p1.setPrice(23.5);
            p1.setProductName("Onion");
            p1.setProductId(1);

            p2 = new Product(2,"Wheat",45.6,12);
            Product p3 = new Product(2,"Wheat",45.6,0);
        } catch (MinimumQuantityException e) {
            System.out.println(e.getMessage());
        }
        Logger.getInstance().log(p2.toString());
        // Creating Customers
        Customer c1 = new Customer(1,"Vishwas","vishwas@cloudthat.com",new CreditCardDetails(123,"123456789","vishwas",123,"05/08"));
        //Creating Orders
        Order o1 = new OrderBuilderImpl()
                .setOrderId(23)
                .setCustomer(c1)
                .addProduct(p1)
                .addProduct(p2)
                .build();

        System.out.println(o1);


    }
}