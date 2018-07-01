package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.Sprite;

class Collision {

    private final CombatSprite source;
    private final CombatSprite target;

    Collision(CombatSprite source, CombatSprite target) {
        this.source = source;
        this.target = target;
    }

    CombatSprite getSource() {
        return source;
    }

    CombatSprite getTarget() {
        return target;
    }
}
