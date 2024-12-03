package com.cloudthat.customannotations;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world123!");

        Class<?> c1 = AnnotationExample.class;
        for (Method method: c1.getDeclaredMethods()){
            if(method.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

                System.out.println("Method: "+method.getName());
                System.out.println("Annotation Value: "+ annotation.value());
            }
        }
    }
}