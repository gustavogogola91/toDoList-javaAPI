package com.api.toDoList.ToDoList.Dtos;

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

}
