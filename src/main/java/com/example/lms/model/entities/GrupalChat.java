package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("GRUPAL")
@Getter
@Setter
public class GrupalChat extends Chat {

    private Long id;
    private Edition edition;
    private Set<User> users = new HashSet<>();

    public GrupalChat() {}
    public GrupalChat(Edition edition) {
        this.edition = edition;
    }

    @ManyToMany
    @JoinTable(
            name = "GrupalChatsUsers", //
            joinColumns = @JoinColumn(name = "grupalChatId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    public Set<User> getUsers() {
        return users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "editionId")
    public Edition getEdition() {
        return edition;
    }
}
