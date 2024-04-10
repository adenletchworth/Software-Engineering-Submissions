package com.cpp.Entity.Chat;

import java.time.LocalDateTime;
import java.util.List;

public class Message {
    User sender;
    List<User> receivers;
    String message;
    LocalDateTime timestamp;

    public Message(User sender, List<User> receivers, String message) {
        this.sender = sender;
        this.receivers = receivers;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender() {
        return sender;
    }

    public List<User> getReceivers() {
        return receivers;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
