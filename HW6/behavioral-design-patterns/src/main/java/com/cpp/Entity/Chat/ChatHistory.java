package com.cpp.Entity.Chat;

import java.util.Stack;

public class ChatHistory {
    private Stack<MessageMemento> history = new Stack<>();

    public void addMessageToHistory(Message message) {
        history.push(new MessageMemento(message.getMessage(), message.getTimestamp()));
    }

    public MessageMemento getLastMessage() {
        return history.isEmpty() ? null : history.pop();
    }
}

