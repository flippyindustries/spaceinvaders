package com.alevat.spaceinvaders.game;

import java.awt.image.BufferedImage;

import com.alevat.spaceinvaders.io.ImageResource;
import com.alevat.spaceinvaders.io.Sprite;

import static com.alevat.spaceinvaders.game.PlayerShotState.IN_FLIGHT;

class Shield implements Sprite {

    static final int Y_POSITION = 56;
    static final int WIDTH = ImageResource.SHIELD.getWidth();

    private final CombatState state;
    private final int x;
    private final BufferedImage image;

    Shield(CombatState state, int x) {
        this.state = state;
        this.x = x;
        this.image = ImageResource.SHIELD.copyBufferedImage();
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
    public BufferedImage getBufferedImage() {
        return image;
    }

}
