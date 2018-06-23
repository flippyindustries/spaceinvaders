package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.InputListener;

interface GameState {

    InputListener getInputListener();

    Game getGame();

    void update();

    Console getConsole();
}
