package com.kmvpsolutions.spring.ehcache.demo.service;

import com.kmvpsolutions.spring.ehcache.demo.entities.User;
import com.kmvpsolutions.spring.ehcache.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "usersCache", key = "#name")
    public User get(String name) {
        System.out.println("Looked for user: " + name);
        return this.userRepository.findByName(name);
    }
}
