package com.cpp.Entity.Chat;

import java.util.Collections;
import java.util.List;

public class User {
    private String name;
    private ChatServer server; 
    private ChatHistory chatHistory; 
    
    public User(String name, ChatServer server) {
        this.name = name;
        this.server = server;
        this.chatHistory = new ChatHistory(); 
    }

    public void sendMessage(List<User> recipients, String content) {
        Message message = new Message(this, recipients, content);
        server.sendMessage(message);
        chatHistory.addMessageToHistory(message); 
    }

    public void sendMessage(User recipient, String content) {
        sendMessage(Collections.singletonList(recipient), content);
    }

    public void receiveMessage(Message message) {
        System.out.println(this.name + " received from " + message.getSender().getName() + ": " + message.getMessage());
    }

    public void undoLastMessage() {
        MessageMemento memento = chatHistory.getLastMessage(); 
        if (memento != null) {
            server.undoMessage(this, memento); 
        }
    }

    public String getName() {
        return name;
    }
}
