package com.hw5.Messages;

import com.hw5.Entity.Media.Media;
import com.hw5.Entity.MessagingApp.MessagingApp;

public class TextMessage implements MessageType{
    protected MessagingApp messagingApp;
    protected Media content;

    public TextMessage(MessagingApp messagingApp, Media content) {
        this.messagingApp = messagingApp;
        this.content = content;
    }
    
    public void setMessageApp(MessagingApp messagingApp) {
        this.messagingApp = messagingApp;
    }

    public void setContent(Media content) {
        this.content = content;
    }

    public String getContentType() {
        return content.getType();
    }

    @SuppressWarnings("unchecked")
    public Media getContent() {
        return content;
    }

    public void sendMessage() {
        if (this.messagingApp == null) {
            System.out.println("Messaging app not set");
            return;
        }

        if (this.content == null) {
            System.out.println("Content not set");
            return;
        }
        
        messagingApp.sendMessage(this.content);
    }
}
