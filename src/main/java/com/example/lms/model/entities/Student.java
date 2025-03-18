package com.example.lms.model.entities;

import java.time.LocalDateTime;

public class Student extends User {

    public Student() {}
    public Student(String email, String name, String surname, String dni, Gender gender, String telephone, String direction, LocalDateTime birthDate, Role role) {
        super(email, name, surname, dni, gender, telephone, direction, birthDate, role);
    }
}
