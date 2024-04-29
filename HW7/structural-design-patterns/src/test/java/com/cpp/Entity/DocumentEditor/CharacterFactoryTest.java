package com.cpp.Entity.DocumentEditor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFactoryTest {

    @Test
    void getAttribute_ShouldReuseExistingInstance_WhenSameAttributesProvided() {
        CharacterAttribute first = CharacterFactory.getAttribute("Arial", "black", 12);
        CharacterAttribute second = CharacterFactory.getAttribute("Arial", "black", 12);

        assertSame(first, second, "Should return the same CharacterAttribute instance for identical attribute requests.");
    }

    @Test
    void getAttribute_ShouldCreateNewInstance_WhenDifferentAttributesProvided() {
        CharacterAttribute first = CharacterFactory.getAttribute("Arial", "black", 12);
        CharacterAttribute second = CharacterFactory.getAttribute("Arial", "red", 12);

        assertNotSame(first, second, "Should return different CharacterAttribute instances for different attribute requests.");
    }

    @Test
    void getAttribute_ShouldCreateNewInstance_WhenDifferentSizesProvided() {
        CharacterAttribute first = CharacterFactory.getAttribute("Arial", "black", 12);
        CharacterAttribute second = CharacterFactory.getAttribute("Arial", "black", 14);

        assertNotSame(first, second, "Should return different CharacterAttribute instances for different sizes.");
    }
}

