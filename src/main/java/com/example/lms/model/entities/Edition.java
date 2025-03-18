package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Edition {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean archived;
    private Course course;
    private Set<Student> students = new HashSet<>();
    private Set<Teacher> teachers = new HashSet<>();

    public Edition() {}
    public Edition(LocalDate startDate, LocalDate endDate, Boolean archived, Course course) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.archived = archived;
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

    @ManyToMany(mappedBy = "editions")
    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.getEditions().add(this);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        student.getEditions().remove(this);
    }

    @ManyToMany(mappedBy = "editions")
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        teacher.getEditions().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
        teacher.getEditions().remove(this);
    }

    @Transient
    public Integer getNumberOfStudents() {
        return students.size();
    }
}
