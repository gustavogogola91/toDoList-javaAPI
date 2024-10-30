package com.api.toDoList.ToDoList.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.toDoList.ToDoList.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    
}
