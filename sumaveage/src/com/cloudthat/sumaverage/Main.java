package com.cloudthat.sumaverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Sum Average Program...");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter the numbers: ");

        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        int sumValue = numbers.stream().mapToInt(Integer::intValue).sum();
        double average = (double) sumValue/n;

        System.out.format("Sum of Numbers is: %d\n",sumValue);
        System.out.format("Average of Numbers is: %.2f",average);
    }
}