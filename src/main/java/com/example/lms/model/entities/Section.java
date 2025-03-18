package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Section {

    private Long id;
    private String name;
    private boolean published;
    private Section parent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne
    public Section getParent() {
        return parent;
    }
}
