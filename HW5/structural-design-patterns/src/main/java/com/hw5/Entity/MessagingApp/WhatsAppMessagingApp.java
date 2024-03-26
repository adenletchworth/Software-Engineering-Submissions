package com.hw5.Entity.MessagingApp;

import com.hw5.Entity.Media.Media;

public class WhatsAppMessagingApp implements MessagingApp{  
    public WhatsAppMessagingApp() {}

    public void sendMessage(Media content) {
        System.out.println("Sending " + content.getType() +  " message via WhatsApp");
    }

}
