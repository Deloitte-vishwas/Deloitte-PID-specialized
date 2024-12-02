package com.cloudthat.streamdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        List of names, find the names starting with A,
        convert to uppercase & collect them as a list
         */
        String[] names = {"Vishwas", "Ajinkya", "Tanmay", "Tejal","Abhay", "Aarushi", "Rithvik", "Mayank", "Arpit", "Aditi", };

        List<String> filteredNames = Arrays.stream(names).parallel()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .toList();

        System.out.println(filteredNames);
    }
}