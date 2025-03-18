package com.example.lms.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {

    private Long id;
    private String name;
    private String description;
    private Integer hours;
    private Boolean archived;

    public Course() {}
    public Course(String name, String description, Integer hours, Boolean archived) {
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.archived = archived;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
