package com.alevat.spaceinvaders.game;

public class Console {

    public void info(String message) {
        System.out.println(message);
    }

    public void error(String message, Throwable throwable) {
        System.err.println(message);
        throwable.printStackTrace();
    }
}
