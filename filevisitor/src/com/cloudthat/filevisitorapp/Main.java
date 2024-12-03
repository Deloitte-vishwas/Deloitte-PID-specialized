package com.cloudthat.filevisitorapp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main extends Object{
    public static void main(String[] args) throws IOException {

        Path startPath = Paths.get("C:\\Users\\VishwasKSingh\\deloitte-workspace\\demos\\filevisitor\\TestDirectory");
        Files.walkFileTree(startPath, new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String firstLine = Files.newBufferedReader(file, Charset.defaultCharset()).readLine();
                System.out.println(firstLine);
                return FileVisitResult.CONTINUE;
            }
        });

    }
}