package com.api.toDoList.ToDoList.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_user")
public class UserModel {

    @Id
    @GeneratedValue
    UUID user_id;

    @Column(nullable = false, length = 80)
    String name;
    @Column(nullable = false, length = 80)
    String email;
    @Column(nullable = false, length = 80)
    String password;
}
