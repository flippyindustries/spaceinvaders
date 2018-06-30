package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.Sprite;

class Collision {

    private final Sprite source;
    private final Sprite target;

    Collision(Sprite source, Sprite target) {
        this.source = source;
        this.target = target;
    }

    Sprite getSource() {
        return source;
    }

    Sprite getTarget() {
        return target;
    }
}
