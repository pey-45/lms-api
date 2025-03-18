package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HasFinalGrade {

    private Long id;
    private Student student;
    private Edition edition;

    public HasFinalGrade() {}
    public HasFinalGrade(Student student, Edition edition) {
        this.student = student;
        this.edition = edition;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    public Student getStudent() {
        return student;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "editionId")
    public Edition getEdition() {
        return edition;
    }

    @Transient
    public float getFinalGrade() {
        return 0;
        // TODO
    }
}
