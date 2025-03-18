package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class User {

    public enum Gender {M, F, NB}
    public enum Role {STUDENT, TEACHER, ADMIN}

    private Long id;
    private String email;
    private String username;
    private String name;
    private String surname;
    private String dni;
    private Gender gender;
    private String telephone;
    private String direction;
    private LocalDateTime birthDate;
    private Role role;
    private Set<GrupalChat> grupalChats = new HashSet<>();

    public User() {}
    public User(String email, String username, String name, String surname, String dni, Gender gender, String telephone,
                String direction, LocalDateTime birthDate, Role role) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.gender = gender;
        this.telephone = telephone;
        this.direction = direction;
        this.birthDate = birthDate;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToMany(mappedBy = "users")
    public Set<GrupalChat> getGrupalChats() {
        return grupalChats;
    }

    @Column(name = "role", insertable = false, updatable = false)
    public Role getRole() {
        return role;
    }
}
