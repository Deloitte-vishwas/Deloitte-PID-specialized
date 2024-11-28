package com.cloudthat.factoryexample;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Square");
        shape2.draw();
    }
}