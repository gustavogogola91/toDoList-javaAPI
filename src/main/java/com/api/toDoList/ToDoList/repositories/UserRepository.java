package com.api.toDoList.ToDoList.repositories;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.toDoList.ToDoList.model.UserModel;

public interface UserRepository extends JpaRepository<UUID, UserModel> {
    
}
