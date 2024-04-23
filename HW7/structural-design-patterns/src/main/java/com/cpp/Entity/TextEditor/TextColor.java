package com.cpp.Entity.TextEditor;

import com.cpp.Entity.TextEditor.enums.Color;

public class TextColor {
    private final Color color;

    public TextColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "TextColor{" +
               "color=" + color +
               '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TextColor textColor = (TextColor) obj;
        return color == textColor.color;
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}

