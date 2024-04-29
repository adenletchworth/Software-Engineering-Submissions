package com.cpp.Entity.DocumentEditor;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Document {
    private List<CharacterWithAttribute> characters;

    public Document() {
        characters = new ArrayList<>();
    }

    public void addCharacter(char c, String font, String color, int size) {
        CharacterAttribute attribute = CharacterFactory.getAttribute(font, color, size);
        characters.add(new CharacterWithAttribute(c, attribute));
    }

    public int getCharactersCount() {
        return characters.size();
    }

    public CharacterWithAttribute getCharacterAtIndex(int index) {
        if (index < 0 || index >= characters.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + characters.size());
        }
        return characters.get(index);
    }

    public void save(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter writer = new BufferedWriter(fw);
        for (CharacterWithAttribute charAttr : characters) {
            writer.write(charAttr.getCharacter() + " {" +
                        charAttr.getAttribute().getFont() + "," +
                        charAttr.getAttribute().getColor() + "," +
                        charAttr.getAttribute().getSize() + "}" + "\n");
        }
        writer.close();
    }

    public void load(String filename) throws IOException {
        characters.clear();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            char character = parts[0].charAt(0);
            String font = parts[1];
            String color = parts[2];
            int size = Integer.parseInt(parts[3]);
            addCharacter(character, font, color, size);
        }
        reader.close();
    }

    public class CharacterWithAttribute {
        private char character;
        private CharacterAttribute attribute;

        public CharacterWithAttribute(char character, CharacterAttribute attribute) {
            this.character = character;
            this.attribute = attribute;
        }

        public char getCharacter() {
            return character;
        }

        public CharacterAttribute getAttribute() {
            return attribute;
        }
    }
}
