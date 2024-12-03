package com.cloudthat.volatileatomicexample;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static volatile boolean stopFlag = false;
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        /*
        Two threads in counter application
        1. thread to increment the counter
        2. thread to monitor a flag to stop incrementing
         */

        Thread incThread = new Thread(()->{
            while (!stopFlag){
                counter.incrementAndGet();
                System.out.println("Counter inremented to: "+counter.get());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Increment Thread interrupted..");
                }
            }
            System.out.println("Increment Thread stopped...");
        },"incrementThread");

        Thread monitorThread = new Thread(()->{
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                System.out.println("Monitor thread interrupted...");
            }
            stopFlag = true;
            System.out.println("Stop flag set to true by "+ Thread.currentThread().getName());
        }, "MonitorThread");

        // starting the threads
        incThread.start();
        monitorThread.start();

        try {
            incThread.join();
            monitorThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted...");
        }

        System.out.println("The Final counter value: "+ counter.get());
        System.out.println("Main Thread Finished");

    }
}