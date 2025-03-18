package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Resource {

    private Long id;
    private String name;
    private String extension;
    private String description;
    private int estimatedMinutes;
    private LocalDateTime limitDate;
    private byte percentage;
    private Section section;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionId")
    public Section getSection() {
        return section;
    }

    @Transient
    public boolean isEvaluable() {
        return percentage > 0;
    }
}
