package edu.javacourse.loader;


import java.util.Iterator;
import java.util.ServiceLoader;

public class Starter {
    public static void main(String[] args) {
        Manager m = new Manager();

//        Messenger msg = new MessengerFirst();

//        ServiceLoader<Messenger> load = ServiceLoader.load(Messenger.class);
//        for (Iterator<Messenger> itMsg = load.iterator(); itMsg.hasNext();) {
//            Messenger next = itMsg.next();
//            next.sendMessage("12345");
//        }

        m.setMessenger(ServiceLoader.load(Messenger.class).iterator().next());
        m.testMethod();
    }
}
