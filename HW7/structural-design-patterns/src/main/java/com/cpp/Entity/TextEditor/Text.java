package com.cpp.Entity.TextEditor;

import com.cpp.Entity.TextEditor.enums.Color;
import com.cpp.Entity.TextEditor.enums.Font;
import com.cpp.Entity.TextEditor.enums.Size;

public class Text {
    private String content; 
    private TextColor textColor; 
    private TextFont textFont; 
    private TextSize textSize; 

    public Text(String content, Color color, Font font, Size size) {
        this.content = content;
        this.textColor = TextFactory.getColor(color);
        this.textFont = TextFactory.getFont(font);
        this.textSize = TextFactory.getSize(size);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TextColor getTextColor() {
        return textColor;
    }

    public TextFont getTextFont() {
        return textFont;
    }

    public TextSize getTextSize() {
        return textSize;
    }

    @Override
    public String toString() {
        return "Text{" +
               "content='" + content + '\'' +
               ", textColor=" + textColor +
               ", textFont=" + textFont +
               ", textSize=" + textSize +
               '}';
    }
}

