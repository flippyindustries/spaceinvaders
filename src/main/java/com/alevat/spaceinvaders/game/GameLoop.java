package com.alevat.spaceinvaders.game;

class GameLoop implements Runnable {

    private final static int TARGET_FPS = 60;

    private final Game game;
    private boolean running;

    GameLoop(Game game) {
        this.game = game;
    }

    void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            executeGameCycle();
        }
    }

    private void executeGameCycle() {
        try {
            getGameState().update();
            getScreen().render();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void quit() {
        running = false;
    }

    private GameState getGameState() {
        return game.getState();
    }

    private Screen getScreen() {
        return game.getScreen();
    }
}
