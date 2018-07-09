package com.kmvpsolutions.spring.ehcache.demo.repository;

import com.kmvpsolutions.spring.ehcache.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
