package edu.javacourse.loader.impl;

import edu.javacourse.loader.Messenger;

public class MessengerSecond implements Messenger {



    @Override
    public void sendMessage(String s) {
        System.out.println("Message 2:" + s);
    }
}
