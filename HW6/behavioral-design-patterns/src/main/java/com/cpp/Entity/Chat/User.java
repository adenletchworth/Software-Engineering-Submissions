package com.cpp.Entity.Chat;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements IterableByUser {
    private String username;
    private List<User> blockedUsers = new ArrayList<>();
    private ChatHistory chatHistory = new ChatHistory();
    private ChatServer server;

    public User(String username, ChatServer server) {
        this.username = username;
        this.server = server;
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(List<User> recipients, String content) {
        server.sendMessage(this, recipients, content);
    }

    public void receiveMessage(Message message) {
        chatHistory.addMessage(message);
    }

    public void undoLastMessage() {
        chatHistory.undoLastMessage();
    }

    public void blockUser(User user) {
        blockedUsers.add(user);
    }

    public boolean isBlocked(User user) {
        return blockedUsers.contains(user);
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }
}

