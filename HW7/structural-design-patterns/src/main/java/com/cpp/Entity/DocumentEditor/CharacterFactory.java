package com.cpp.Entity.DocumentEditor;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private static final Map<String, CharacterAttribute> attributes = new HashMap<>();

    public static CharacterAttribute getAttribute(String font, String color, int size) {
        String key = font + color + size;
        if (!attributes.containsKey(key)) {
            attributes.put(key, new CharacterAttribute(font, color, size));
        }
        return attributes.get(key);
    }
}
