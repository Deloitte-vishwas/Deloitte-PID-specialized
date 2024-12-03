package com.cloudthat.ecomappv4;


import com.cloudthat.ecomappv4.entity.Customer;
import com.cloudthat.ecomappv4.entity.Order;
import com.cloudthat.ecomappv4.entity.Product;
import com.cloudthat.ecomappv4.repository.InMemoryRepository;
import com.cloudthat.ecomappv4.service.EcommerceService;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Ecommerce application ");
        System.out.println("----------------------------------");
        InMemoryRepository<Product, Long> productRepository = new InMemoryRepository<>();
        InMemoryRepository<Customer,Long> customerRepository = new InMemoryRepository<>();
        InMemoryRepository<Order, Long> orderRepository = new InMemoryRepository<>();

        EcommerceService service = new EcommerceService(productRepository,orderRepository,customerRepository);
        service.loadInitialData();



//        // Create a new product
//        Product newProduct1 = new Product(25L,"Laptop", 25000.00);
//        service.createProduct(newProduct1);
//
//        Product newProduct2 = new Product(26L,"Computer", 25000.00);
//        service.createProduct(newProduct2);
//
//        System.out.println("Added Products successfully");
        service.displayAllProducts();
//
//        Customer newCustomer1 = new Customer(1L, "Vishwas", "vishwas@cloudthat.com");
//        Customer newCustomer2 = new Customer(2L,"Anusha","anusha@cloudthat.com");
//
//        service.createCustomer(newCustomer1);
//        service.createCustomer(newCustomer2);
//
//        System.out.println("Added Customer successfully");
//
//        Order newOrder1 = new Order(1L, newCustomer1, Arrays.asList(newProduct1,newProduct2));
//        Order newOrder2 = new Order(2L,newCustomer2, newProduct1);
//
//        service.createOrder(newOrder1);
//        service.createOrder(newOrder2);
//
//        System.out.println("Orders added successfully");
//
//        System.out.println("Orders in the system are: ");
        try {
            System.out.println(service.findOrderById(1L));
            System.out.println(service.findOrderById(2L));
            System.out.println(service.findOrderById(3L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Orders in the System: ");
        service.displayAllOrders();

    }
}