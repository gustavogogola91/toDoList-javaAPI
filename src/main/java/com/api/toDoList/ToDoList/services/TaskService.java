package com.api.toDoList.ToDoList.services;

import java.util.UUID;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.toDoList.ToDoList.repositories.TaskRepository;

import jakarta.transaction.Transactional;

import com.api.toDoList.ToDoList.model.TaskModel;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public TaskModel save(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskModel> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    public List<TaskModel> getCompletedTasks() {
        return taskRepository.getByCompletedTrue();
    }

    public List<TaskModel> getNotCompletedTasks() {
        return taskRepository.getByCompletedFalse();
    }

    public boolean delete(UUID id) {
        
        taskRepository.deleteById(id);
        return true;
    }
}
