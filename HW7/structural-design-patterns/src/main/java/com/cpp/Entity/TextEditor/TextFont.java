package com.cpp.Entity.TextEditor;

import com.cpp.Entity.TextEditor.enums.Font;

public class TextFont {
    private final Font font;

    public TextFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return this.font;
    }

    @Override
    public String toString() {
        return "TextFont{" +
               "font=" + font +
               '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TextFont textFont = (TextFont) obj;
        return font == textFont.font;
    }

    @Override
    public int hashCode() {
        return font.hashCode();
    }
}
