package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.Sprite;

public interface CombatSprite extends Sprite {

    boolean detectCollision(Sprite sprite);

}
