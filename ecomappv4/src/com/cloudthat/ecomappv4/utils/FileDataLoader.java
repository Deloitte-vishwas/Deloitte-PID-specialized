package com.cloudthat.ecomappv4.utils;

import com.cloudthat.ecomappv4.entity.Entity;
import com.cloudthat.ecomappv4.repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.concurrent.CompletableFuture;

public class FileDataLoader<T extends Entity<ID>,ID> {
    private Repository<T,ID> repository;
    private String filePath;
    private Function<String, T> mapper;

    public FileDataLoader(Repository<T, ID> repository, String filePath, Function<String, T> mapper) {
        this.repository = repository;
        this.filePath = filePath;
        this.mapper = mapper;
    }

    public CompletableFuture<Void> loadDataAsync() {
        Path path = Paths.get(filePath);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Files.lines(path)
                        .map(mapper)
                        .forEach(repository::save);
                return null;
            } catch (IOException e) {
                throw new RuntimeException("Error reading file: " + filePath, e);
            }
        });
    }

//    public void loadData(){
//        new Thread(()->{
//            try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
//                String line;
//                while ((line = reader.readLine())!= null){
//                    T entity = mapper.apply(line);
//                    repository.save(entity);
//                    System.out.println("Loaded data");
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        });
//    }
}
