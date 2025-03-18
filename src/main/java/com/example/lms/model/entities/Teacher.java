package com.example.lms.model.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends User {

    private Set<Edition> editions = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "TeachersEditions", //
            joinColumns = @JoinColumn(name = "teacherId"),
            inverseJoinColumns = @JoinColumn(name = "editionId")
    )
    public Set<Edition> getEditions() {
        return editions;
    }

    public void addEdition(Edition edition) {
        this.editions.add(edition);
        edition.addTeacher(this);
    }

    public void removeEdition(Edition edition) {
        this.editions.remove(edition);
        edition.removeTeacher(this);
    }
}
