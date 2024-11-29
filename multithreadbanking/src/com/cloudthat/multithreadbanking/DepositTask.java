package com.cloudthat.multithreadbanking;


public class DepositTask extends Thread{
    private BankAccount account;

    public DepositTask(BankAccount account){
        this.account = account;
    }
    @Override
    public void run() {
        account.deposit(500);
    }
}



//public class DepositTask implements Runnable{
//    private BankAccount account;
//
//    public DepositTask(BankAccount account){
//        this.account = account;
//    }
//    @Override
//    public void run() {
//        account.deposit(500);
//    }
//}

