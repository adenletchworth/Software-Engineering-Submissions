package com.hw5.Messages;

import com.hw5.Entity.Media.Media;
import com.hw5.Entity.MessagingApp.MessagingApp;

public interface MessageType {
    public void setMessageApp(MessagingApp messagingApp);
    public void setContent(Media content);
    public String getContentType();
    <Media> Media getContent();
    public void sendMessage();
}
