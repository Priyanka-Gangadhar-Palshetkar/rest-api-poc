package com.almameal.api.poc.service;

import com.almameal.api.poc.model.User;
import com.almameal.api.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }
}
