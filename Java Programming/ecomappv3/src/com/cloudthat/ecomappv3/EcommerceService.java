package com.cloudthat.ecomappv3;

import com.cloudthat.ecomappv3.entity.Customer;
import com.cloudthat.ecomappv3.entity.Order;
import com.cloudthat.ecomappv3.entity.Product;
import com.cloudthat.ecomappv3.repository.Repository;

import java.util.List;

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
    // Order Methods for CRUD operations
}
