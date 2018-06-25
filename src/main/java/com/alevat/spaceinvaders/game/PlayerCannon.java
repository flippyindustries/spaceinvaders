package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.ImageResource;
import com.alevat.spaceinvaders.io.Sprite;

class PlayerCannon implements Sprite {

    private static final double VELOCITY_PIXELS_PER_FRAME = 1.5;
    private static final int STARTING_X_POSITION = 20;
    private static final int Y_POSITION = 32;
    private static final int WIDTH = 13;

    private final CombatState state;
    private HorizontalDirection direction = HorizontalDirection.STILL;

    double x = STARTING_X_POSITION;

    PlayerCannon(CombatState state) {
        this.state = state;
    }

    public void update() {
        switch (direction) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            default:
                // do nothing
        }
    }

    private void moveLeft() {
        if (x > CombatState.LEFT_X_BOUNDARY) {
            x = x - VELOCITY_PIXELS_PER_FRAME;
        }
    }

    private void moveRight() {
        if (x < CombatState.RIGHT_X_BOUNDARY - WIDTH) {
            x = x + VELOCITY_PIXELS_PER_FRAME;
        }
    }

    HorizontalDirection getDirection() {
        return direction;
    }

    void setDirection(HorizontalDirection direction) {
        getConsole().info("PlayerCannon direction set to " + direction);
        this.direction = direction;
    }

    @Override
    public int getX() {
        return (int) Math.round(x);
    }

    @Override
    public int getY() {
        return Y_POSITION;
    }

    @Override
    public ImageResource getImageResource() {
        return ImageResource.PLAYER_CANNON;
    }

    private Console getConsole() {
        return state.getConsole();
    }
}
