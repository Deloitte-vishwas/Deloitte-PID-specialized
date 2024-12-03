package com.cloudthat.ecomappv1;

public class Customer {

    private int customerId;
    private String customerName;
    private String emailId;
    private CreditCardDetails creditCardDetails;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String emailId, CreditCardDetails creditCardDetails) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailId = emailId;
        this.creditCardDetails = creditCardDetails;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public CreditCardDetails getCreditCardDetails() {
        return creditCardDetails;
    }

    public void setCreditCardDetails(CreditCardDetails creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }
}
