package com.cpp;

import java.io.IOException;
import com.cpp.Entity.DocumentEditor.Document;

public class DocumentEditorDriver {

    public static void main(String[] args) {
        try {
            DocumentEditorDriver driver = new DocumentEditorDriver();

            driver.createHelloWorldDocument("HelloWorldCS5800-1.txt", "Arial", "Red", 12);

            driver.createHelloWorldDocument("HelloWorldCS5800-2.txt", "Calibri", "Blue", 14);

            driver.createHelloWorldDocument("HelloWorldCS5800-3.txt", "Verdana", "Black", 16);

            driver.createHelloWorldDocument("HelloWorldCS5800-4.txt", "Arial", "Blue", 14);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHelloWorldDocument(String filename, String font, String color, int size) throws IOException {
        Document doc = new Document();
        String content = "HelloWorldCS5800";
        for (char c : content.toCharArray()) {
            if (c != 'H'){
                doc.addCharacter(c, font, color, size);
            }
            else{
                doc.addCharacter(c, "Arial", "Black", 16);
            }
        }
        doc.save(filename);
    }
}


