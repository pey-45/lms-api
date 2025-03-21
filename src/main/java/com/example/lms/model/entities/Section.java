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
    private Boolean published;
    private Edition edition;
    private Section parentSection;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "editionId")
    public Edition getEdition() {
        return edition;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentSectionId")
    public Section getParentSection() {
        return parentSection;
    }
}
