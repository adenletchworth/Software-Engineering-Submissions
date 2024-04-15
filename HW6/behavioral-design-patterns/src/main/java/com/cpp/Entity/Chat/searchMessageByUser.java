package com.cpp.Entity.Chat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchMessageByUser implements Iterator<Message> {
    private List<Message> filteredMessages;
    private int currentIndex = 0;

    public SearchMessageByUser(List<Message> history, User userToSearchWith) {
        filteredMessages = new ArrayList<>();
        for (Message message : history) {
            if (message.getSender().equals(userToSearchWith) || message.getRecipient().equals(userToSearchWith)) {
                filteredMessages.add(message);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return currentIndex < filteredMessages.size();
    }

    @Override
    public Message next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more messages.");
        }
        return filteredMessages.get(currentIndex++);
    }
}


