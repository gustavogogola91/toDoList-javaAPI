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
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;

import com.api.toDoList.ToDoList.Dtos.TaskDto;
import com.api.toDoList.ToDoList.model.TaskModel;
import com.api.toDoList.ToDoList.services.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@CrossOrigin("*")
@Controller
@RequestMapping("/tasks/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskByUser());
    }

    @GetMapping("/completed/")
    public ResponseEntity<List<TaskModel>> getCompleted() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getCompletedTasks());
    }

    @GetMapping("/not-completed")
    public ResponseEntity<List<TaskModel>> getNotCompelted() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getNotCompletedTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TaskModel>> getTaskById(@PathVariable final UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveTask(@RequestBody @Valid TaskDto taskDto) {

        var taskModel = new TaskModel();
        BeanUtils.copyProperties(taskDto, taskModel);

        if (taskDto.isCompleted()) {
            taskModel.setCompleted(true);
        }

        if (taskDto.getDueDate() != null) {
            taskModel.setDueDate(taskDto.getDueDate());
        }

        taskModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable UUID id, @RequestBody TaskDto taskDto) {

        Optional<TaskModel> taskModelList = taskService.getTaskById(id);

        TaskModel taskModel = taskModelList.get();

        taskModel.setName(taskDto.getName());
        taskModel.setDescription(taskDto.getDescription());
        taskModel.setDueDate(taskDto.getDueDate());
        taskModel.setCompleted(taskDto.isCompleted());

        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.delete(id));
    }
}
