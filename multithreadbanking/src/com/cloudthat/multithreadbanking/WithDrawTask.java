package com.cloudthat.multithreadbanking;

public class WithDrawTask implements Runnable{
    private BankAccount account;

    public WithDrawTask(BankAccount account){
        this.account = account;
    }
    @Override
    public void run() {
        account.withDraw(300);
    }
}
