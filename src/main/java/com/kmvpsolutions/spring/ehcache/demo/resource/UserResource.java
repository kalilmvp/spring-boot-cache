package com.kmvpsolutions.spring.ehcache.demo.resource;

import com.kmvpsolutions.spring.ehcache.demo.entities.User;
import com.kmvpsolutions.spring.ehcache.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{name}")
    public User getUser(@PathVariable("name") String name) {
        return this.userService.get(name);
    }
}
