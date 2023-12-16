package edu.javacource.simplesocket;

public class SimpleClient {
    public static void main(String[] args) {
        for (int i = 0; i < 400; i++) {
            new SimpleClientThread().start();
        }
    }
}
