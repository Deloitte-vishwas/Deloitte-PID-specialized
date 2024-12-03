package com.cloudthat.ecomappv4.entity;

public class Product implements Entity<Long>{
    private Long id;
    private String productName;
    private Double productPrice;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Product() {
    }

    public Product(Long id, String productName, Double productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public static Product fromCSV(String s) {
        String[] fields = s.split(",");
        Product product = new Product();
        product.setId(Long.parseLong(fields[0]));
        product.setProductName(fields[1]);
        product.setProductPrice(Double.parseDouble(fields[2]));
        return product;
    }
}
