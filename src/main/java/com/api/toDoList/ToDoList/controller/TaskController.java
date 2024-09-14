package com.api.toDoList.ToDoList.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.toDoList.ToDoList.Dtos.TaskDto;
import com.api.toDoList.ToDoList.model.TaskModel;
import com.api.toDoList.ToDoList.services.TaskService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/")
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
    }

    @GetMapping("/tasks/completed/")
    public ResponseEntity<List<TaskModel>> getCompleted() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getCompletedTasks());
    }

    @GetMapping("/tasks/not-completed")
    public ResponseEntity<List<TaskModel>> getNotCompelted() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getNotCompletedTasks());
    }   

    @GetMapping("/task/{id}")
    public ResponseEntity<Optional<TaskModel>> getTaskById(@PathVariable final UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskById(id));
    }

    @PostMapping("/task/")
    public ResponseEntity<Object> saveTask(@RequestBody @Valid TaskDto taskDto) {

        var taskModel = new TaskModel();
        BeanUtils.copyProperties(taskDto, taskModel);

        if(taskDto.isCompleted()) {
            taskModel.setCompleted(true);
        }

        if(taskDto.getDueDate() != null) {
            taskModel.setDueDate(taskDto.getDueDate());
        }

        taskModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskModel));
    }

}
