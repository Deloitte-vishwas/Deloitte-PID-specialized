package com.cloudthat.multithreadbanking;

public class BalanceTask implements Runnable{
    private BankAccount account;

    public BalanceTask(BankAccount account){
        this.account = account;
    }
    @Override
    public void run() {
        account.showBalance();
    }
}
