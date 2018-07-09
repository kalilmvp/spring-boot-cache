package com.kmvpsolutions.spring.ehcache.demo.loader;

import com.kmvpsolutions.spring.ehcache.demo.entities.User;
import com.kmvpsolutions.spring.ehcache.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {

    @Autowired
    private UserRepository usersRepository;

    @PostConstruct
    public void load() {
        this.usersRepository.save(this.getData());
    }

    public List<User> getData() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("Kalil Peixoto", 5000d));
        usersList.add(new User("Carlos Valadares", 2400d));
        return usersList;
    }
}
