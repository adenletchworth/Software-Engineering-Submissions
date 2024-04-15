package com.cpp.Entity.Chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

class SearchMessageByUserTest {
    private List<Message> messageList;
    private User jack;
    private User jill;
    private User jane;

    @BeforeEach
    void setUp() {
        jack = new User("Jack", null);
        jill = new User("Jill", null);
        jane = new User("Jane", null);

        messageList = new ArrayList<>(Arrays.asList(
            new Message(jack, jill, "Hi Jill!", 1L),
            new Message(jill, jack, "Hello Jack!", 2L),
            new Message(jane, jill, "Greetings Jill.", 3L),
            new Message(jack, jane, "Hello Jane!", 4L)
        ));
    }

    @Test
    void testIteratorForJackMessages() {
        SearchMessageByUser iterator = new SearchMessageByUser(messageList, jack);

        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        Message first = iterator.next();
        assertEquals("Hi Jill!", first.getContent(), "Jack sends this to Jill.");

        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        Message second = iterator.next();
        assertEquals("Hello Jack!", second.getContent(), "Jill sends this to Jack.");

        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        Message third = iterator.next();
        assertEquals("Hello Jane!", third.getContent(), "Jack sends this to Jane.");

        assertFalse(iterator.hasNext(), "Iterator should not have more elements.");
    }

    @Test
    void testIteratorForJaneMessages() {
        SearchMessageByUser iterator = new SearchMessageByUser(messageList, jane);

        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        Message first = iterator.next();
        assertEquals("Greetings Jill.", first.getContent(), "Jane sends this to Jill.");

        assertTrue(iterator.hasNext(), "Iterator should have next element.");
        Message second = iterator.next();
        assertEquals("Hello Jane!", second.getContent(), "Jack sends this to Jane.");

        assertFalse(iterator.hasNext(), "Iterator should not have more elements.");
    }

    @Test
    void testIteratorNoMoreElementsThrowsException() {
        SearchMessageByUser iterator = new SearchMessageByUser(messageList, jack);
        while (iterator.hasNext()) { 
            iterator.next();
        }

        assertThrows(NoSuchElementException.class, iterator::next, "Should throw NoSuchElementException when no more elements.");
    }

    @Test
    void testIteratorNoRelevantMessages() {
        User userUnknown = new User("Unknown", null);
        SearchMessageByUser iterator = new SearchMessageByUser(messageList, userUnknown);

        assertFalse(iterator.hasNext(), "Iterator should not have any elements for an unknown user.");
    }
}
