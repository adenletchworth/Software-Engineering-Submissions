package com.cpp.Entity.Chat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public MessageMemento getLastMessage() {
        if (messages.isEmpty()) return null;
        Message last = messages.get(messages.size() - 1);
        return new MessageMemento(last.getContent(), last.getTimestamp());
    }

    public void undoLastMessage() {
        if (messages.isEmpty()) return;
        messages.remove(messages.size() - 1);
    }

    public boolean containsMessageWithContent(String content) {
        return messages.stream().anyMatch(message -> message.getContent().equals(content));
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return new SearchMessageByUser(messages, userToSearchWith);
    }
}

