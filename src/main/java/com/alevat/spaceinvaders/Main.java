package com.alevat.spaceinvaders;

import com.alevat.spaceinvaders.awt.JavaAWTGameStarter;
import com.alevat.spaceinvaders.game.Console;

public class Main {

    public static void main(String[] args) {
        Console console = new Console();
        new JavaAWTGameStarter().start(console);
    }

}
