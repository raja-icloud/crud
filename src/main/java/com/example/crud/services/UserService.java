package com.example.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.repositories.UserRepository;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public Object getAllUsers(String id) {
        if (id != null) {
            return userRepository.findById(id).orElse(null);
        }
        return userRepository.findAll();
    }

    public Object createUser(Object user) {
        return userRepository.save((com.example.crud.models.User) user);
    }

    public Object updateUser(String id, Object user) {
        if (userRepository.existsById(id)) {
            ((com.example.crud.models.User) user).setId(id);
            return userRepository.save((com.example.crud.models.User) user);
        }
        return null;
    }

    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
