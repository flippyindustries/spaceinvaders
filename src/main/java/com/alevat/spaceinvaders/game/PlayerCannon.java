package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.Sprite;
import com.alevat.spaceinvaders.io.SpriteIdentifier;

class PlayerCannon implements Sprite {

    private static final int STARTING_X_POSITION = 20;
    private static final int Y_POSITION = 32;

    private final CombatState state;
    private HorizontalDirection direction = HorizontalDirection.STILL;

    int x = STARTING_X_POSITION;

    PlayerCannon(CombatState state) {
        this.state = state;
    }

    public void update() {
        switch (direction) {
            case LEFT:
                moveLeft();
            case RIGHT:
                moveRight();
            default:
                // do nothing
        }
        System.out.println(x);
    }

    private void moveLeft() {
        if (x > Screen.LEFT_X_BOUNDARY) {
            x--;
        }
    }

    private void moveRight() {
        if (x < Screen.RIGHT_X_BOUNDARY) {
            x++;
        }
    }

    HorizontalDirection getDirection() {
        return direction;
    }

    void setDirection(HorizontalDirection direction) {
        this.direction = direction;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return Y_POSITION;
    }

    @Override
    public SpriteIdentifier getIdentifier() {
        return SpriteIdentifier.PLAYER_CANNON;
    }
}
