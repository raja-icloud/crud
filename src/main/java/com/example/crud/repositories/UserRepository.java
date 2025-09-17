package com.example.crud.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crud.models.User;

public interface UserRepository extends MongoRepository<User, String> {
}
