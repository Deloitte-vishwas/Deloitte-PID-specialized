package com.cloudthat.ecomappv1;

public class ElectronicsProduct extends Product{

    private int warrantyPeriod;

    public ElectronicsProduct() {
    }

    public ElectronicsProduct(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}
