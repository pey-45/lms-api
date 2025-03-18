package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Edition {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
    private Course course;

    public Edition() {}
    public Edition(LocalDate startDate, LocalDate endDate, boolean active, Course course) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="courseId")
    public Course getCourse() {
        return course;
    }

    @Transient
    public int getNumberOfStudents() {
        return 0;
        //TODO
    }
}
