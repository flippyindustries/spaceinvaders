package com.alevat.spaceinvaders.io;

public interface InputListener {

    void leftPressed();
    void leftReleased();
    void rightPressed();
    void rightReleased();
    void firePressed();

    void addCredit();

    void startOnePlayer();
    void startTwoPlayers();

    void reset();
    void quit();

}
