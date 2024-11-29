package com.cloudthat.squarecalculator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        int totalNumbers = 1000;
        int chunksize = 100;
        int numThreads = totalNumbers / chunksize;



        try(var executorService = Executors.newFixedThreadPool(numThreads)){
            // Arrays to store numbers & squares
            int[] numbers = new int[totalNumbers];
            int[] squares = new int[totalNumbers];

            // initialize the numbers array
            for (int i = 0; i < totalNumbers; i++) {
                numbers[i] = i + 1;
            }

            // submit tasks to executor
            for (int j = 0; j < numThreads; j++) {
                int start = j * chunksize;
                int end = start + chunksize;

                executorService.submit(()->{
                    for (int m = start; m < end; m++) {
                        squares[m] = numbers[m] * numbers[m];
                        System.out.println("Thread "+ Thread.currentThread().getName() +
                                " calculated square of "+ numbers[m] +
                                " as " + squares[m]);
                    }
                });
            }

            executorService.shutdown();

            try {
                executorService.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                System.out.println("Executor Interrupted..");
            }

        }
        System.out.println("\n All squares calculated");
    }
}