package com.api.toDoList.ToDoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.toDoList.ToDoList.model.TaskModel;
import com.api.toDoList.ToDoList.services.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/")
    public List<TaskModel> getAllTasks() {
        return taskService.getAllTasks();
    }
}
