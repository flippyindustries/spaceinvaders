package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.AudioEngine;
import com.alevat.spaceinvaders.io.InputOutputResources;
import com.alevat.spaceinvaders.io.RenderingEngine;

public class Game {

    private final InputOutputResources inputOutputResources;
    private final Console console;
    private final AudioEngine audioEngine;
    private final RenderingEngine renderingEngine;
    private final GameInputDispatcher inputListener;
    private final Screen screen;

    private boolean running;
    private GameState state;

    public Game(InputOutputResources inputOutputResources, Console console) {
        this.inputOutputResources = inputOutputResources;
        this.renderingEngine = inputOutputResources.getRenderingEngine();
        this.audioEngine = inputOutputResources.getAudioEngine();
        this.console = console;
        this.inputListener = new GameInputDispatcher(this);
        this.screen = new Screen(this, renderingEngine);
    }

    public void start() {
        getConsole().info("Starting...");
        running = true;
        renderingEngine.initializeScreen();
        state = new CombatState(this);
        inputOutputResources.registerInputListener(inputListener);
        while (running) {
            try {
                state.update();
                screen.render();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        inputOutputResources.close();
    }

    GameState getState() {
        return state;
    }

    void quit() {
        running = false;
    }

    Console getConsole() {
        return console;
    }

    Screen getScreen() {
        return screen;
    }
}
