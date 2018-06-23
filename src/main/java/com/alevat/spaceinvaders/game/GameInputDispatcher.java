package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.InputListener;

class GameInputDispatcher implements InputListener {

    private final Game game;

    public GameInputDispatcher(Game game) {
        this.game = game;
    }

    @Override
    public void leftPressed() {
        game.getState().getInputListener().leftPressed();
    }

    @Override
    public void leftReleased() {
        game.getState().getInputListener().leftReleased();
    }

    @Override
    public void rightPressed() {
        game.getState().getInputListener().rightPressed();
    }

    @Override
    public void rightReleased() {
        game.getState().getInputListener().rightReleased();
    }

    @Override
    public void firePressed() {
        game.getState().getInputListener().firePressed();
    }

    @Override
    public void addCredit() {
        game.getState().getInputListener().addCredit();
    }

    @Override
    public void startOnePlayer() {
        game.getState().getInputListener().startOnePlayer();
    }

    @Override
    public void startTwoPlayers() {
        game.getState().getInputListener().startTwoPlayers();
    }

    @Override
    public void reset() {
        game.getState().getInputListener().reset();
    }

    @Override
    public void quit() {
        game.getState().getInputListener().quit();
    }
}
