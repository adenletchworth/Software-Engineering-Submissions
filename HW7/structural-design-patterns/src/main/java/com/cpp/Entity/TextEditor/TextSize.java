package com.cpp.Entity.TextEditor;

import com.cpp.Entity.TextEditor.enums.Size;

public class TextSize {
    private final Size size;

    public TextSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "TextSize{" +
                "size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TextSize textSize = (TextSize) obj;
        return size == textSize.size;
    }

    @Override
    public int hashCode() {
        return size.hashCode();
    }
}
