package com.cpp.Entity.DocumentEditor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    private Document document;

    @BeforeEach
    void setUp() {
        document = new Document();
    }

    @Test
    void addCharacter_ShouldAddCharacterWithAttributes() {
        document.addCharacter('a', "Arial", "black", 12);
        assertEquals(1, document.getCharactersCount(), "Document should have exactly one character after adding.");
    }

    @Test
    void saveToFile_ShouldWriteCharactersToFile(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("testOutput.txt");

        document.addCharacter('a', "Arial", "black", 12);
        document.addCharacter('b', "Arial", "black", 12);

        document.save(file.toString());

        BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
        String firstLine = reader.readLine();
        String secondLine = reader.readLine();
        reader.close();

        assertEquals("a {Arial,black,12}", firstLine);
        assertEquals("b {Arial,black,12}", secondLine);
    }

    @Test
    void loadFromFile_ShouldLoadCharactersFromFile(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("testInput.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()));
        writer.write("a,Arial,black,12\nb,Arial,black,12\n");
        writer.close();

        document.load(file.toString());

        assertEquals('a', document.getCharacterAtIndex(0).getCharacter(), "First character should be 'a'.");
        assertEquals("Arial", document.getCharacterAtIndex(0).getAttribute().getFont(), "Font of first character should be Arial.");
        assertEquals('b', document.getCharacterAtIndex(1).getCharacter(), "Second character should be 'b'.");
        assertEquals("black", document.getCharacterAtIndex(1).getAttribute().getColor(), "Color of second character should be black.");
}

}
