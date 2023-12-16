package edu.javacourse.loader.impl;

import edu.javacourse.loader.Messenger;

public class MessengerFirst implements Messenger {


    @Override
    public void sendMessage(String s) {
        System.out.println("Message is sent:" + s);
    }
}
