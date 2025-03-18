package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("STUDENT")
@Getter
@Setter
public class Student extends User {

    private Set<Edition> editions = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "StudentsEditions", //
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "editionId")
    )
    public Set<Edition> getEditions() {
        return editions;
    }

    public void addEdition(Edition edition) {
        this.editions.add(edition);
        edition.getStudents().add(this);
    }

    public void removeEdition(Edition edition) {
        this.editions.remove(edition);
        edition.getStudents().remove(this);
    }
}
