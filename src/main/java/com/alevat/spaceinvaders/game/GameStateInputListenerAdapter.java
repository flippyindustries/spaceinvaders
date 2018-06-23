package com.alevat.spaceinvaders.game;

import java.awt.event.KeyListener;

import com.alevat.spaceinvaders.io.InputListener;

abstract class GameStateInputListenerAdapter implements InputListener {

    @Override
    public void leftPressed() {
        // default - ignore
    }

    @Override
    public void leftReleased() {
        // default - ignore
    }

    @Override
    public void rightPressed() {
        // default - ignore
    }

    @Override
    public void rightReleased() {
        // default - ignore
    }

    @Override
    public void firePressed() {
        // default - ignore
    }

    @Override
    public void addCredit() {
        // default - ignore
    }

    @Override
    public void startOnePlayer() {
        // default - ignore
    }

    @Override
    public void startTwoPlayers() {
        // default - ignore
    }

    @Override
    public void reset() {
        // default - ignore
    }

    @Override
    public void quit() {
        getGameState().getGame().quit();
    }

    abstract GameState getGameState();

    Console getConsole() {
        return getGameState().getConsole();
    }
}
