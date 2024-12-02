package com.cloudthat.genericsdemo;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1L, "Laptop", 25000.0, 25);
        Customer customer = new Customer(1L,"Vishwas","vishwas@cloudthat.com");

        ProductContainer productContainer = new ProductContainer(product);
        // This would not work
        // ProductContainer productContainer1 = new ProductContainer(customer);

        GenericContainer<Product> genericContainer1 = new GenericContainer<>(product);
        GenericContainer<Customer> genericContainer2 = new GenericContainer<>(customer);

    }
}