package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Grade {

    private Long id;
    private String testName;
    private float grade;
    private User student;
    private Edition edition;
    private Resource resource;

    public Grade() {}
    public Grade(String testName, float grade, User user, Edition edition, Resource resource) {
        this.testName = testName;
        this.grade = grade;
        this.student = user;
        this.edition = edition;
        this.resource = resource;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    public User getStudent() {
        return student;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "editionId")
    public Edition getEdition() {
        return edition;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resourceId")
    public Resource getResource() {
        return resource;
    }
}
