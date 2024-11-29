package com.cloudthat.multithreadexample2;

public class Main {
    public static void main(String[] args) {

        WorkerThread workerThread = new WorkerThread();

        workerThread.setName("Worker Thread");

        workerThread.start();

        try {
            workerThread.join(5000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting.....");
        }


        if (workerThread.isAlive()){
            System.out.println("Worker Thread is taking too long, Interrupting.....");
            workerThread.interrupt();
        }

        try {
            workerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting.....");
        }

        System.out.println("Main thread finished");
    }
}