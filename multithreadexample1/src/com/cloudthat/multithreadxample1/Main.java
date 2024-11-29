package com.cloudthat.multithreadxample1;

class T1 extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello World");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class T2 extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello Vishwas");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {

        T1 t1 = new T1();
        T2 t2 = new T2();

        t1.start();
        Thread.sleep(5000);
        t2.start();
    }
}

// implement the runnable interface
// extend thread class