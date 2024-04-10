package com.cpp.Entity.Chat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChatServer {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Set<String>> blockedUsers = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getName(), user);
    }

    public void sendMessage(Message message) {
        for (User receiver : message.getReceivers()) {
            String receiverName = receiver.getName();
            if (!isBlocked(receiverName, message.getSender().getName())) {
                if (users.containsKey(receiverName)) {
                    users.get(receiverName).receiveMessage(message);
                }
            } else {
                System.out.println("Message blocked from " + message.getSender().getName() + " to " + receiverName);
            }
        }
    }

    private boolean isBlocked(String receiverName, String senderName) {
        return blockedUsers.getOrDefault(receiverName, new HashSet<>()).contains(senderName);
    }

    public void undoMessage(User sender, MessageMemento memento) {
        System.out.println("Message from " + sender.getName() + " was undone. Content was: " + memento.getMessage());
    }

    public void blockUser(String user, String userToBlock) {
        blockedUsers.computeIfAbsent(user, k -> new HashSet<>()).add(userToBlock);
    }
}
