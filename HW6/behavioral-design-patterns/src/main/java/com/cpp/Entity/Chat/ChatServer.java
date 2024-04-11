package com.cpp.Entity.Chat;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ChatServer {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void unregisterUser(User user) {
        users.remove(user.getUsername());
    }

    public void sendMessage(User sender, List<User> recipients, String content) {
        long timestamp = System.currentTimeMillis();
        recipients.forEach(recipient -> {
            if (!recipient.isBlocked(sender)) {
                Message message = new Message(sender, recipient, content, timestamp);
                recipient.receiveMessage(message);
                sender.getChatHistory().addMessage(message);
            }
        });
    }

    public void blockUser(User requester, User toBlock) {
        requester.blockUser(toBlock);
    }
}

