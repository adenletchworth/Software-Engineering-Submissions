package com.cpp.Entity.Chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

class UserTest {
    private User jack;
    private User jill;
    private User jane;
    private ChatServer server;

    @BeforeEach
    void setUp() {
        server = new ChatServer();
        jack = new User("Jack", server);
        jill = new User("Jill", server);
        jane = new User("Jane", server);

        server.registerUser(jack);
        server.registerUser(jill);
        server.registerUser(jane);
    }

    @Test
    void sendMessage() {
        jack.sendMessage(List.of(jill), "Hello, Jill!");
        
        assertTrue(jill.receivedMessagesContains("Hello, Jill!"));
    }

    @Test
    void receiveMessage() {
        Message message = new Message(jill, jack, "Hi, Jack!", System.currentTimeMillis());
        jack.receiveMessage(message);

        assertTrue(jack.receivedMessagesContains("Hi, Jack!"));
    }

    @Test
    void blockAndCheckUser() {
        jack.blockUser(jill);

        assertTrue(jack.isBlocked(jill));
        assertFalse(jack.isBlocked(jane));
    }

    @Test
    void undoLastMessage() {
        jack.sendMessage(List.of(jill), "Message 1");
        jack.sendMessage(List.of(jill), "Message 2");
        jack.undoLastMessage();

        assertFalse(jack.receivedMessagesContains("Message 2"));
        assertTrue(jack.receivedMessagesContains("Message 1"));
    }

    @Test
    void iteratorOverUserMessages() {
        jack.sendMessage(List.of(jill), "Message to Jill");
        jill.sendMessage(List.of(jack), "Reply from Jill");

        Iterator<Message> iterator = jack.iterator(jill);
        assertTrue(iterator.hasNext());

        Message msg = iterator.next();
        assertEquals("Message to Jill", msg.getContent());
        assertTrue(iterator.hasNext());

        msg = iterator.next();
        assertEquals("Reply from Jill", msg.getContent());
        assertFalse(iterator.hasNext());
    }
}
