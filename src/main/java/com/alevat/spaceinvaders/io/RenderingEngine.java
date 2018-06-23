package com.alevat.spaceinvaders.io;

public interface RenderingEngine {

    void initializeScreen();

    void addSprite(Sprite sprite);

    void removeSprite(Sprite sprite);

    void renderScreen();
}
