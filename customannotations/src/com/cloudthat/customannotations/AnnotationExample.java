package com.cloudthat.customannotations;

public class AnnotationExample {

    @MyAnnotation(value = "Hello, My annotations")
    public void welcome(){
        System.out.println("Printing Welcome Message");
    }
}
