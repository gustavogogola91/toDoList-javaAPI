package com.api.toDoList.ToDoList.services;

import java.util.UUID;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.toDoList.ToDoList.repositories.TaskRepository;
import com.api.toDoList.ToDoList.model.TaskModel;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskModel> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }
}
