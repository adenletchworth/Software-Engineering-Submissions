package com.cpp.Entity.Chat;

public class Message {
    private User sender;
    private User recipient;
    private String content;
    private long timestamp;

    public Message(User sender, User recipient, String content, long timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = timestamp;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
