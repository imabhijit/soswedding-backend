package com.penelakut.soswedding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.penelakut.soswedding.model.User;
import com.penelakut.soswedding.repository.ProviderServiceRepository;
import com.penelakut.soswedding.repository.UserRepository;

@RestController
public class UserAPI {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderServiceRepository providerServiceRepository;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @PatchMapping("/user")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){ userRepository.delete(user); }

}
