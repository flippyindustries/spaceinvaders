package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.InputListener;

class GameInputDispatcher implements InputListener {

    private final Game game;

    public GameInputDispatcher(Game game) {
        this.game = game;
    }

    @Override
    public void leftPressed() {
        getConsole().info("leftPressed");
        game.getState().getInputListener().leftPressed();
    }

    @Override
    public void leftReleased() {
        getConsole().info("leftReleased");
        game.getState().getInputListener().leftReleased();
    }

    @Override
    public void rightPressed() {
        getConsole().info("rightPressed");
        game.getState().getInputListener().rightPressed();
    }

    @Override
    public void rightReleased() {
        getConsole().info("rightReleased");
        game.getState().getInputListener().rightReleased();
    }

    @Override
    public void firePressed() {
        getConsole().info("firePressed");
        game.getState().getInputListener().firePressed();
    }

    @Override
    public void addCredit() {
        getConsole().info("addCredit");
        game.getState().getInputListener().addCredit();
    }

    @Override
    public void startOnePlayer() {
        getConsole().info("startOnePlayer");
        game.getState().getInputListener().startOnePlayer();
    }

    @Override
    public void startTwoPlayers() {
        getConsole().info("startTwoPlayers");
        game.getState().getInputListener().startTwoPlayers();
    }

    @Override
    public void reset() {
        getConsole().info("reset");
        game.getState().getInputListener().reset();
    }

    @Override
    public void quit() {
        getConsole().info("quit");
        game.getState().getInputListener().quit();
    }

    private Console getConsole() {
        return game.getConsole();
    }
}
