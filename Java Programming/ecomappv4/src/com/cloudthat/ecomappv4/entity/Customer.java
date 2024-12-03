package com.cloudthat.ecomappv4.entity;

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

    public static Customer fromCSV(String s) {
        String[] fields = s.split(",");
        Customer customer = new Customer();
        customer.setId(Long.parseLong(fields[0]));
        customer.setCustomerName(fields[1]);
        customer.setEmail(fields[2]);
        return customer;
    }
}
