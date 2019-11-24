package com.penelakut.soswedding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.penelakut.soswedding.model.User;
import com.penelakut.soswedding.repository.UserRepository;

@RestController
public class UserAPI {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/user/{uuid}")
    public User getUserById(@PathVariable String uuid){
        return userRepository.findUserByUuid(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No User found with uuid %s ", uuid)));
    }

    @GetMapping("/user/firstName/{firstName}")
    public User getUserByFirstName(@PathVariable String firstName){
        return userRepository.findUserByFirstName(firstName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("No User found with first name %s ", firstName)));
    }

    @PatchMapping("/user")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){ userRepository.delete(user); }

}
