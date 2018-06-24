package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.InputListener;

interface GameState {

    void update();

    Game getGame();

    InputListener getInputListener();

    Console getConsole();
}
