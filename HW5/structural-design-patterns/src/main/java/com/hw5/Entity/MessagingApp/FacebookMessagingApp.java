package com.hw5.Entity.MessagingApp;

import com.hw5.Entity.Media.Media;

public class FacebookMessagingApp implements MessagingApp{
    public FacebookMessagingApp() {}

    public void sendMessage(Media content) {
        System.out.println("Sending " + content.getType() +  " message via Facebook");
    }

}
