package com.cpp.Entity.Chat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class MessageTest {

    @Test
    void testMessageConstructionAndAccessors() {
        User sender = new User("Sender", null);  
        User recipient = new User("Recipient", null);
        String content = "Hello, this is a test message.";
        long timestamp = System.currentTimeMillis();

        Message message = new Message(sender, recipient, content, timestamp);

        assertSame(sender, message.getSender(), "The sender returned was not the one set in the constructor.");
        assertSame(recipient, message.getRecipient(), "The recipient returned was not the one set in the constructor.");
        assertEquals(content, message.getContent(), "The content returned was not the one set in the constructor.");
        assertEquals(timestamp, message.getTimestamp(), "The timestamp returned was not the one set in the constructor.");
    }
}
