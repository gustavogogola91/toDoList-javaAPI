package com.api.toDoList.ToDoList.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.toDoList.ToDoList.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, UUID>{

}
