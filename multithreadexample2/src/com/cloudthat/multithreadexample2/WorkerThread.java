package com.cloudthat.multithreadexample2;

public class WorkerThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started.");

        for (int i = 0; i < 20; i++) {
            System.out.println("Executing step "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
        System.out.println(Thread.currentThread().getName()+ " finished.");
    }
}
