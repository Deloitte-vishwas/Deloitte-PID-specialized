package com.cloudthat.multithreadbanking;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();


        Thread depositThread = new DepositTask(account);
        Thread withDrawThread = new Thread(new WithDrawTask(account));
        Thread balanceThread = new Thread(new BalanceTask(account));

        depositThread.start();
        withDrawThread.start();
        balanceThread.start();
    }
}