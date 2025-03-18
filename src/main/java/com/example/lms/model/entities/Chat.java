package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "chatType", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class Chat {

    private Long id;
    private String chatType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "chatType", insertable = false, updatable = false)
    public String getChatType() {
        return chatType;
    }
}