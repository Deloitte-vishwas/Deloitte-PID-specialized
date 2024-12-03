package com.cloudthat.ecomappv4.service;



import com.cloudthat.ecomappv4.entity.Customer;
import com.cloudthat.ecomappv4.entity.Order;
import com.cloudthat.ecomappv4.entity.Product;
import com.cloudthat.ecomappv4.exception.ResourceNotFoundException;
import com.cloudthat.ecomappv4.repository.Repository;
import com.cloudthat.ecomappv4.utils.FileDataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EcommerceService {

    private final Repository<Product, Long> productRepository;
    private final Repository<Order, Long> orderRepository;
    private final Repository<Customer, Long> customerRepository;

    public EcommerceService(Repository<Product, Long> productRepository, Repository<Order, Long> orderRepository, Repository<Customer, Long> customerRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    // Product Methods for CRUD operations
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductById(Long id){
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id){
        productRepository.delete(productRepository.findById(id));
    }

    public List<Product> findProductsByName(String name){
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getProductName().contains(name))
                .toList();
    }
    // Customer Methods for CRUD operations
    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id);
    }

    public void deleteCustomer(Long id){
        customerRepository.delete(customerRepository.findById(id));
    }

    public List<Customer> findCustomersByName(String name){
        return customerRepository.findAll()
                .stream()
                .filter(c -> c.getCustomerName().contains(name))
                .toList();
    }
    // Order Methods for CRUD operations
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public Order findOrderById(Long id){
        Order order = orderRepository.findById(id);
        if (order == null){
            throw new ResourceNotFoundException("Order with id "+id + " is NOT FOUND");
        }
        return order;
    }

    public void deleteOrder(Long id){
        orderRepository.delete(orderRepository.findById(id));
    }

    public void loadInitialData(){
        FileDataLoader<Product, Long> productLoader = new FileDataLoader<>(productRepository, "data/products.csv", Product::fromCSV);
        FileDataLoader<Customer, Long> customerLoader = new FileDataLoader<>(customerRepository, "data/customers.csv", Customer::fromCSV);
        FileDataLoader<Order, Long> orderLoader = new FileDataLoader<>(orderRepository, "data/orders.csv", Order::fromCSV);

        CompletableFuture.allOf(
                productLoader.loadDataAsync(),
                orderLoader.loadDataAsync(),
                customerLoader.loadDataAsync()
        ).join();

//        productLoader.loadData();
//        customerLoader.loadData();
//        orderLoader.loadData();
    }

    public void displayAllProducts(){
        List<Product> products = productRepository.findAll();
        for (Product p: products){
            System.out.println(p);
        }
    }

    public void displayAllOrders() {
        List<Order> orders = orderRepository.findAll();
        for (Order o: orders){
            System.out.println(o);
        }
    }
}
