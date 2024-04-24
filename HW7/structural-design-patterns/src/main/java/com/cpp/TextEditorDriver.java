package com.cpp;

import com.cpp.Entity.TextEditor.*;
import com.cpp.Entity.TextEditor.enums.*;

public class TextEditorDriver {
    public static void main(String[] args) {
        Text text1 = new Text("HelloWorldCS5800", Color.RED, Font.VERDANA, Size.SIZE_12);
        Text text2 = new Text("HelloWorldCS5800", Color.BLUE, Font.ARIAL, Size.SIZE_14);
        Text text3 = new Text("HelloWorldCS5800", Color.BLACK, Font.VERDANA, Size.SIZE_16);
        Text text4 = new Text("HelloWorldCS5800", Color.RED, Font.CALIBRI, Size.SIZE_14);

        System.out.println(text1);
        System.out.println(text2);
        System.out.println(text3);
        System.out.println(text4);

        Text text5 = new Text("HelloWorldCS5800", Color.RED, Font.VERDANA, Size.SIZE_12);
        System.out.println("Text1 and Text5 have the same instances for color, font, and size: " +
                           (text1.getTextColor() == text5.getTextColor() &&
                            text1.getTextFont() == text5.getTextFont() &&
                            text1.getTextSize() == text5.getTextSize()));
    }
}
