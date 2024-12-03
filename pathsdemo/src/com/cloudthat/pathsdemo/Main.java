package com.cloudthat.pathsdemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Path Class Demo");

        Path path = Paths.get("src/com/cloudthat/pathsdemo/testFile.txt");
//        Path path = Paths.get("C:\\Users\\VishwasKSingh\\deloitte-workspace\\demos\\pathsdemo\\src\\com\\cloudthat\\pathsdemo\\testFile.txt");
        System.out.printf("File Name: %s%n",path.getFileName());
        System.out.printf("Parent: %s%n",path.getParent());
        System.out.printf("Absolute Path: %s%n", path.toAbsolutePath());
//        System.out.printf("Real Path: %s%n", path.toRealPath());

        Path path1 = Paths.get("/home/vishwas");
        System.out.printf("Resultant path: %s%n", path1.resolve("foobar"));

//        String seperator = File.separator;
        String seperator = FileSystems.getDefault().getSeparator();
        System.out.printf("Path Seperator is %s%n",seperator);
    }
}