package com.cloudthat.ecomappv3.entity;

public class Customer implements Entity<Long>{

    private Long id;
    private String customerName;
    private String email;

    public Customer() {
    }

    public Customer(Long id, String customerName, String email) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
