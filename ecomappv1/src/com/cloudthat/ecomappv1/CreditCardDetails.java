package com.cloudthat.ecomappv1;

public class CreditCardDetails {

    private int id;
    private String cardNumber;
    private String cardHolder;
    private int cvv;
    private String expiry;

    public CreditCardDetails() {
    }

    public CreditCardDetails(int id, String cardNumber, String cardHolder, int cvv, String expiry) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
        this.expiry = expiry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
