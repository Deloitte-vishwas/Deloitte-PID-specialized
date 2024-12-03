package com.cloudthat.ecomappv4.utils;

import com.cloudthat.ecomappv4.entity.Entity;
import com.cloudthat.ecomappv4.repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class FileDataLoader<T extends Entity<ID>,ID> {
    private final Repository<T,ID> repository;
    private final String filePath;
    private final Function<String, T> mapper;

    public FileDataLoader(Repository<T, ID> repository, String filePath, Function<String, T> mapper) {
        this.repository = repository;
        this.filePath = filePath;
        this.mapper = mapper;
    }

    public void loadData(){
        new Thread(()->{
            try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
                String line;
                while ((line = reader.readLine())!= null){
                    T entity = mapper.apply(line);
                    repository.save(entity);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        });
    }
}
