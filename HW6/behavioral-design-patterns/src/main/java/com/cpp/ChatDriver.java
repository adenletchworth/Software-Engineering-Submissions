package com.cpp;

import java.util.Arrays;
import java.util.Iterator;

import com.cpp.Entity.Chat.*;

public class ChatDriver {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User jack = new User("Jack", server);
        User jill = new User("Jill", server);
        User jane = new User("Jane", server);

        server.registerUser(jack);
        server.registerUser(jill);
        server.registerUser(jane);

        jack.sendMessage(Arrays.asList(jill, jane), "Hello Jill, Jane...");
        jill.sendMessage(Arrays.asList(jack), "Hi Jack!");
        jane.sendMessage(Arrays.asList(jack), "Why are you so mean!");

        jack.blockUser(jane);

        jane.sendMessage(Arrays.asList(jack), "Jack?");

        System.out.println("Jack's messages:");
        printMessages(jack, jack);

        System.out.println("Jill's messages:");
        printMessages(jill, jill);

        System.out.println("Jane's messages:");
        printMessages(jane, jane);
        
        jack.undoLastMessage();
        System.out.println("Jack's messages after undo:");
        printMessages(jack, jack);
    }

    private static void printMessages(User user, User userToSearchWith) {
        Iterator<Message> iterator = user.iterator(userToSearchWith);
        while (iterator.hasNext()) {
            Message message = iterator.next();
            System.out.println("From: " + message.getSender().getUsername() +
                               " || To: " + message.getRecipient().getUsername() +
                               " || Content: " + message.getContent());
        }
    }
}

