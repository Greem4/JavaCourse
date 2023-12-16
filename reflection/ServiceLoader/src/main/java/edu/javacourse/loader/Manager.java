package edu.javacourse.loader;

public class Manager {

    private Messenger messenger;

    public void setMessenger(Messenger messenger) {
        this.messenger = messenger;
    }

    public void testMethod() {
        messenger.sendMessage("Message");
    }
}
