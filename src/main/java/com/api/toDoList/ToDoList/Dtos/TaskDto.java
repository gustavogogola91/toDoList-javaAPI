package com.api.toDoList.ToDoList.Dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private LocalDateTime dueDate;
    private boolean completed;

}
