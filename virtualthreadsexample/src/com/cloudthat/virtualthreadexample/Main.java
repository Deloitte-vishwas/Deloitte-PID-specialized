package com.cloudthat.virtualthreadexample;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 0; i <= 10 ; i++) {
                int taskId = i;
                executor.submit(() ->{
                    System.out.println("Task "+ taskId + " started by " + Thread.currentThread());

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                System.out.println("Task "+ taskId + " was interrupted.");
                            }
                    System.out.println("Task "+ taskId + " completed by "+ Thread.currentThread());
                        }
                );

            }
        }
        System.out.println("All tasks submitted. Main thread ends.");
    }
}