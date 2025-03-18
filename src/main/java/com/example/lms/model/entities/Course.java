package com.example.lms.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course {

    private Long id;
    private String name;
    private String description;
    private int hours;
    private boolean active;

    public Course() {}
    public Course(String name, String description, int hours, boolean active) {
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.active = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
