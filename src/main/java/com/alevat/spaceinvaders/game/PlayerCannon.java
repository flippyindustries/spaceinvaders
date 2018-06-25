package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.AudioEngine;
import com.alevat.spaceinvaders.io.ImageResource;
import com.alevat.spaceinvaders.io.SoundResource;
import com.alevat.spaceinvaders.io.Sprite;

class PlayerCannon implements Sprite {

    private static final double VELOCITY_PIXELS_PER_FRAME = 1.0;
    private static final int STARTING_X_POSITION = 20;
    static final int Y_POSITION = 32;
    static final int WIDTH = 13;
    static final int HEIGHT = 8;
    static final int BARREL_X_OFFSET = 7;

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
            x -= VELOCITY_PIXELS_PER_FRAME;
        }
    }

    private void moveRight() {
        if (x < CombatState.RIGHT_X_BOUNDARY - WIDTH) {
            x += VELOCITY_PIXELS_PER_FRAME;
        }
    }

    HorizontalDirection getDirection() {
        return direction;
    }

    void setDirection(HorizontalDirection direction) {
        getConsole().info("PlayerCannon direction set to " + direction);
        this.direction = direction;
    }

    void fire() {
        if (state.getPlayerShot() == null) {
            state.setPlayerShot(new PlayerShot(state, this));
            getAudioEngine().play(SoundResource.FIRE_SHOT);
        }
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

    private AudioEngine getAudioEngine() {
        return state.getGame().getIOResources().getAudioEngine();
    }

}
