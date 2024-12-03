package com.cloudthat.genericsdemo;

public class ProductContainer {

    private Product product;

    public ProductContainer() {
    }

    public ProductContainer(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
