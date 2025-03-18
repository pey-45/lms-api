package com.example.lms.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ChatAccess {

    private Long id;
    private LocalDateTime date;
    private User user;
    private Chat chat;

    public ChatAccess() {}
    public ChatAccess(User user, Chat chat) {
        this.user = user;
        this.chat = chat;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    public User getUser() {
        return user;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "chatId")
    public Chat getChat() {
        return chat;
    }
}
