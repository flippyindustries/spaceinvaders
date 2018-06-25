package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.ImageResource;
import com.alevat.spaceinvaders.io.Sprite;

class PlayerShot implements Sprite {

    private static final double VELOCITY_PIXELS_PER_FRAME = 4;

    private final CombatState state;
    private final int x;
    private double y = PlayerCannon.Y_POSITION + PlayerCannon.HEIGHT - VELOCITY_PIXELS_PER_FRAME;

    PlayerShot(CombatState state, PlayerCannon cannon) {
        this.state = state;
        this.x = cannon.getX() + PlayerCannon.BARREL_X_OFFSET;
        state.getScreen().addSprite(this);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return (int) Math.round(y);
    }

    @Override
    public ImageResource getImageResource() {
        return ImageResource.PLAYER_SHOT;
    }

    void update() {
        y += VELOCITY_PIXELS_PER_FRAME;
        if (y >= Screen.HEIGHT) {
            state.getScreen().removeSprite(this);
            state.setPlayerShot(null);
        }
    }

}
