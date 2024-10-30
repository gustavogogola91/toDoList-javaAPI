package com.api.toDoList.ToDoList.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_task")
public class TaskModel {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user")
    private UserModel user;
    @Column(nullable = false, length = 500)
    private String description;
    @Column(nullable = false)
    private LocalDateTime dueDate;
    @Column(nullable = false)
    private LocalDateTime creationDate;
    @Column(nullable = false)
    private boolean completed;

}
