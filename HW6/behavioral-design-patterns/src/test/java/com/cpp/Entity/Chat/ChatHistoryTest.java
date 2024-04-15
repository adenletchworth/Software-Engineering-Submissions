package com.cpp.Entity.Chat;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChatHistoryTest {
    private ChatHistory chatHistory;
    private User sender;
    private User recipient;

    @BeforeEach
    void setUp() {
        chatHistory = new ChatHistory();
        sender = new User("Sender", null); 
        recipient = new User("Recipient", null);
    }

    @Test
    void addMessageAndCheckLastMessage() {
        Message message = new Message(sender, recipient, "Hello World", System.currentTimeMillis());
        chatHistory.addMessage(message);

        MessageMemento memento = chatHistory.getLastMessage();

        assertNotNull(memento, "Sending a message should create a memento.");
        assertEquals(message.getContent(), memento.getContent(), "The memento content should be the same as the added message.");
        assertEquals(message.getTimestamp(), memento.getTimestamp(), "The memnto timestamp should be the same as the added message.");
    }

    @Test
    void getLastMessageReturnsCorrectMemento() {
        Message firstMessage = new Message(sender, recipient, "First message sent", System.currentTimeMillis());
        Message lastMessage = new Message(sender, recipient, "Last message sent", System.currentTimeMillis());

        chatHistory.addMessage(firstMessage);
        chatHistory.addMessage(lastMessage);

        MessageMemento memento = chatHistory.getLastMessage();

        assertNotNull(memento, "Adding messages should create a memento.");
        assertEquals(lastMessage.getContent(), memento.getContent(), "The Memento content should be the same as last message.");
        assertEquals(lastMessage.getTimestamp(), memento.getTimestamp(), "The Memento timestamp should be the same as the last message.");
    }

    @Test
    void getLastMessageFromEmptyHistoryReturnsNull() {
        assertNull(chatHistory.getLastMessage(), "Retrieving last message from an empty history should return null.");
    }

    @Test
    void undoLastMessageSuccessfully() {
        chatHistory.addMessage(new Message(sender, recipient, "To be undone", System.currentTimeMillis()));
        chatHistory.undoLastMessage();
        assertNull(chatHistory.getLastMessage(), "Chat history state should be empty after undoing last message.");
    }

    @Test
    void undoLastMessageEmptyHistoryDoesNothing() {
        assertDoesNotThrow(() -> chatHistory.undoLastMessage(), "Undoing last message on an empty history should not throw.");
    }

    @Test
    void iteratorReturnsCorrectMessages() {
        User userToSearchWith = sender;

        Message message1 = new Message(sender, recipient, "Message 1", System.currentTimeMillis());
        Message message2 = new Message(recipient, sender, "Message 2", System.currentTimeMillis());

        chatHistory.addMessage(message1);
        chatHistory.addMessage(message2);

        Iterator<Message> iterator = chatHistory.iterator(userToSearchWith);

        assertTrue(iterator.hasNext(), "Adding messages should make iterator have next.");
        assertEquals(message1, iterator.next(), "First message should be from sender.");
        assertEquals(message2, iterator.next(), "Second message should be to sender.");
        assertFalse(iterator.hasNext(), "Iterator should have no more messages.");
    }

    @Test
    void iteratorThrowsExceptionWhenNoMoreElements() {
        chatHistory.addMessage(new Message(sender, recipient, "Hello World", System.currentTimeMillis()));

        Iterator<Message> iterator = chatHistory.iterator(sender);
        iterator.next(); 
        
        assertThrows(NoSuchElementException.class, iterator::next, "Iterator should throw when no more elements.");
    }
}
