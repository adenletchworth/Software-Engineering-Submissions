package com.hw5;

import com.hw5.Entity.Media.*;
import com.hw5.Entity.Messages.*;
import com.hw5.Entity.MessagingApp.*;

public class MessageDriver {
    public static void main(String[] args) {
        MessagingApp facebook = new FacebookMessagingApp();
        MessagingApp telegram = new TelegramMessagingApp();
        MessagingApp whatsApp = new WhatsAppMessagingApp();

        Media image = new ImageMedia();
        Media video = new VideoMedia();
        Media text = new TextMedia();

        MessageType faceBookTextMessage = new TextMessage(facebook, image);
        faceBookTextMessage.sendMessage();

        MessageType telegramVideoMessage = new VideoMessage(telegram, video);
        telegramVideoMessage.sendMessage();

        MessageType whatsAppImageMessage = new ImageMessage(whatsApp, text);
        whatsAppImageMessage.sendMessage();
    }
}
