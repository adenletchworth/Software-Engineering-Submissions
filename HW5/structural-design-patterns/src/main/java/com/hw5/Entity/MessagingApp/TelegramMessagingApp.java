package com.hw5.Entity.MessagingApp;

import com.hw5.Entity.Media.Media;

public class TelegramMessagingApp implements MessagingApp{
    public TelegramMessagingApp() {}

    public void sendMessage(Media content) {
        System.out.println("Sending " + content.getType() +  " message via Telegram");
    }
}
