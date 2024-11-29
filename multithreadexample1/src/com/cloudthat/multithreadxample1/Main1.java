package com.cloudthat.multithreadxample1;

class T3 implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello World");
        }

    }
}

class T4 implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello Vishwas");
        }

    }
}


public class Main1 {
    public static void main(String[] args) {

        T3 t3 = new T3();
        T4 t4 = new T4();

        new Thread(t3).start();
        new Thread(t4).start();
    }
}

// implement the runnable interface
// extend thread class