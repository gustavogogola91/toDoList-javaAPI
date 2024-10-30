package com.api.toDoList.ToDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.api.toDoList.ToDoList.services.UserService;

@CrossOrigin("*")
@Controller
public class UserController {
    
    @Autowired
    UserService userService;
}
