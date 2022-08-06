package com.almameal.api.poc.service;

import com.almameal.api.poc.model.User;
import com.almameal.api.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Objects;

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

    public User saveUser(User user) {
        if(Objects.isNull(user.getUserId())) {
            user.setCreatedDate(new Date(System.currentTimeMillis()));
        } else {
            User userInfo = userRepository.findById(user.getUserId()).orElse(null);
            if(Objects.nonNull(userInfo)) {
                user.setCreatedDate(userInfo.getCreatedDate());
            }
            user.setUpdatedDate(new Date(System.currentTimeMillis()));
        }
        return userRepository.save(user);
    }

    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "SUCCESS";
    }
}
