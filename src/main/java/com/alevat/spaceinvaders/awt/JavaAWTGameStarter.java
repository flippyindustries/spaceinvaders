package com.alevat.spaceinvaders.awt;

import com.alevat.spaceinvaders.game.Console;
import com.alevat.spaceinvaders.game.Game;
import com.alevat.spaceinvaders.io.InputOutputResources;

public class JavaAWTGameStarter {

    public void start(Console console) {
        InputOutputResources inputOutputResources = new JavaInputOutputResources(console);
        new Game(inputOutputResources, console).start();
    }
}
