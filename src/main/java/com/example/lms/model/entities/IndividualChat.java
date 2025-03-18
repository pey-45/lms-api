package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("INDIVIDUAL")
@Getter
@Setter
public class IndividualChat extends Chat {

    private Long id;
    private User user1;
    private User user2;

    public IndividualChat() {}
    public IndividualChat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user1Id")
    public User getUser1() {
        return user1;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user2Id")
    public User getUser2() {
        return user2;
    }
}
