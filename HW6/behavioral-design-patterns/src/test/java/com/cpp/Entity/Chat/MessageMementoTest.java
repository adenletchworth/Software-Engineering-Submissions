package com.cpp.Entity.Chat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MessageMementoTest {

    @Test
    void testMessageMementoConstructionAndAccessors() {
        String content = "This is a saved state of a message.";
        long timestamp = System.currentTimeMillis();

        MessageMemento memento = new MessageMemento(content, timestamp);

        assertEquals(content, memento.getContent(), "The content returned was not the one set in the constructor.");
        assertEquals(timestamp, memento.getTimestamp(), "The timestamp returned was not the one set in the constructor.");
    }

}
