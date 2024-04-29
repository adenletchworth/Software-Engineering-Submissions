package com.cpp.Entity.DocumentEditor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterAttributeTest {

    @Test
    void constructor_ShouldCorrectlyAssignFont() {
        CharacterAttribute attribute = new CharacterAttribute("Arial", "black", 12);
        assertEquals("Arial", attribute.getFont(), "Font should match the constructor input.");
    }

    @Test
    void constructor_ShouldCorrectlyAssignColor() {
        CharacterAttribute attribute = new CharacterAttribute("Arial", "black", 12);
        assertEquals("black", attribute.getColor(), "Color should match the constructor input.");
    }

    @Test
    void constructor_ShouldCorrectlyAssignSize() {
        CharacterAttribute attribute = new CharacterAttribute("Arial", "black", 12);
        assertEquals(12, attribute.getSize(), "Size should match the constructor input.");
    }
}
