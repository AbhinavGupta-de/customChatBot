package org.abhinavgpt.workshopgpt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Chat {

    @Id
    private Long id;
    private String message;
    private long userId;
    private LocalDateTime dateTime;

    public Chat() {
    }

    public Chat(Long id, String message, long user) {
        this.id = id;
        this.message = message;
        this.userId = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUser() {
        return userId;
    }

    public void setUser(long user) {
        this.userId = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
