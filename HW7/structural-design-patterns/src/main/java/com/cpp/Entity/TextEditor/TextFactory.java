package com.cpp.Entity.TextEditor;

import java.util.HashMap;
import java.util.Map;

import com.cpp.Entity.TextEditor.enums.Color;
import com.cpp.Entity.TextEditor.enums.Font;
import com.cpp.Entity.TextEditor.enums.Size;


public class TextFactory {
    private static final Map<Color, TextColor> textColors = new HashMap<>();
    private static final Map<Font, TextFont> textFonts = new HashMap<>();
    private static final Map<Size, TextSize> textSizes = new HashMap<>();

    public static TextColor getColor(Color color) {
        TextColor textColor = textColors.get(color);
        if (textColor == null) {
            textColor = new TextColor(color);
            textColors.put(color, textColor);
        }
        return textColor;
    }

    public static TextFont getFont(Font font) {
        TextFont textFont = textFonts.get(font);
        if (textFont == null) {
            textFont = new TextFont(font);
            textFonts.put(font, textFont);
        }
        return textFont;
    }

    public static TextSize getSize(Size size) {
        TextSize textSize = textSizes.get(size);
        if (textSize == null) {
            textSize = new TextSize(size);
            textSizes.put(size, textSize);
        }
        return textSize;
    }
}
