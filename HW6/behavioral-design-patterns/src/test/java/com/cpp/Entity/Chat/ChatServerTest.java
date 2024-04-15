package com.cpp.Entity.Chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

class ChatServerTest {
    private ChatServer server;
    private User jack;
    private User jill;
    private User jane;

    @BeforeEach
    void setUp() {
        server = new ChatServer();
        jack = new User("Jack", server);
        jill = new User("Jill", server);
        jane = new User("Jane", server);
    }

    @Test
    void registerAndUnregisterUser() {
        server.registerUser(jack);
        server.registerUser(jill);

        assertTrue(server.isUserRegistered(jack.getUsername()));
        assertTrue(server.isUserRegistered(jill.getUsername()));

        server.unregisterUser(jack);
        assertFalse(server.isUserRegistered(jack.getUsername())); 
        assertTrue(server.isUserRegistered(jill.getUsername())); 
    }

    @Test
    void sendMessageToSingleRecipient() {
        server.registerUser(jack);
        server.registerUser(jill);
        server.sendMessage(jack, Arrays.asList(jill), "Hello Jill!");

        assertTrue(jill.receivedMessagesContains("Hello Jill!"));
    }

    @Test
    void blockUserPreventsMessageDelivery() {
        server.registerUser(jack);
        server.registerUser(jane);
        jack.blockUser(jane);

        server.sendMessage(jack, Arrays.asList(jane), "Hi Jane!");
        assertFalse(!jane.receivedMessagesContains("Hi Jane!")); 
    }

    @Test
    void sendMessageIgnoresBlockedUsers() {
        server.registerUser(jack);
        server.registerUser(jill);
        server.registerUser(jane);

        jill.blockUser(jack);
        server.sendMessage(jack, Arrays.asList(jill, jane), "Hello everyone!");
        assertFalse(jill.receivedMessagesContains("Hello everyone!")); 
        assertTrue(jane.receivedMessagesContains("Hello everyone!")); 
    }

    @Test
    void blockUserAndSendMessage() {
        server.registerUser(jack);
        server.registerUser(jill);

        jack.blockUser(jill);
        server.sendMessage(jack, Arrays.asList(jill), "Are you there, Jill?");
        assertFalse(!jill.receivedMessagesContains("Are you there, Jill?")); 
    }
}
