package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.RenderingEngine;
import com.alevat.spaceinvaders.io.Sprite;

public class Screen {

    public static final int WIDTH = 224;
    public static final int HEIGHT = 256;

    private final Game game;
    private final RenderingEngine renderingEngine;

    Screen(Game game, RenderingEngine renderingEngine) {
        this.game = game;
        this.renderingEngine = renderingEngine;
    }

    void removeSprite(Sprite sprite) {
        renderingEngine.removeSprite(sprite);
    }

    void addSprite(Sprite sprite) {
        renderingEngine.addSprite(sprite);
    }

    void render() {
        renderingEngine.renderScreen();
    }

}
