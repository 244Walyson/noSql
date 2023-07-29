package com.waly.mongoDbProject.config;

import com.waly.mongoDbProject.models.entities.User;
import com.waly.mongoDbProject.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void init(){

        repository.deleteAll();

        User maria = new User(null, "maria do grau", "maria@gmail.com");
        User alex = new User(null, "alex do grau", "alex@gmail.com");
        User bob = new User(null, "bob do grau", "bob@gmail.com");



        repository.saveAll(Arrays.asList(maria, alex, bob));
    }
}