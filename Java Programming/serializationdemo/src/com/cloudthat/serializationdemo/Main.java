package com.cloudthat.serializationdemo;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person();
        person.setName("Vishwas");
        person.setAge(20);
        person.setHeight(20);

        System.out.println(person);

        // To simulate seralization
        FileOutputStream fileOutputStream = new FileOutputStream("person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Person person1 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(person1);

    }
}