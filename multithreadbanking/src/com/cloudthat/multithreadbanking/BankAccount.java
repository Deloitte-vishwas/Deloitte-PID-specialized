package com.cloudthat.multithreadbanking;

public class BankAccount {
    private int balance = 10_000;

    public synchronized void deposit(int amount){
        balance += amount;
        System.out.println("Deposited "+ amount + ". Current Balance: "+ balance);
    }

    public synchronized void withDraw(int amount){
        if( balance >= amount){
            balance -= amount;
            System.out.println("Withdrew "+ amount + ". Current Balance: "+ balance);
        }else {
            System.out.println("Insufficient balance for withdrawal of "+ amount);
        }
    }

    public synchronized void showBalance(){
        System.out.println("Current Balance: "+ balance);
    }
}
