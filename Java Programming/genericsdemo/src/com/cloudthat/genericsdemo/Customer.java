package com.cloudthat.genericsdemo;

public class Customer {

    private Long customerId;
    private String customerName;
    private String emailId;

    public Customer() {
    }

    public Customer(Long customerId, String customerName, String emailId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailId = emailId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
