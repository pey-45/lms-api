package com.example.lms.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {

    public enum Gender {M, F, NB}
    public enum Role {STUDENT, TEACHER, ADMIN}

    private Long id;
    private String email;
    private String name;
    private String surname;
    private String dni;
    private Gender gender;
    private String telephone;
    private String direction;
    private LocalDateTime birthDate;
    private Role role;

    public User() {}
    public User(String email, String name, String surname, String dni, Gender gender, String telephone, String direction, LocalDateTime birthDate, Role role) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.gender = gender;
        this.telephone = telephone;
        this.direction = direction;
        this.birthDate = birthDate;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
